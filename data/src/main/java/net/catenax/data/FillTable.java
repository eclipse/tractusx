//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.data;

import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.table.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * An application that fills a table (ODATA, Azure Storage Table) with json data
 */
public class FillTable {

    protected String connectionString;
    protected File jsonFile;
    protected String tableName;
    protected String partitionKey;
    protected String rowKey;
    protected boolean asObject;
    protected boolean asArray;
    protected boolean replace;

    public int insertData() throws URISyntaxException, InvalidKeyException, StorageException, IOException {
        int inserts=0;

        var storageAccount = CloudStorageAccount.parse(connectionString);
        var tableClient = storageAccount.createCloudTableClient();
        var cloudTable = tableClient.getTableReference(tableName);
        cloudTable.createIfNotExists();

        // parsing file
        JSONArray objects;
        var tokenizer=new JSONTokener(new FileReader(jsonFile));
        if(isAsArray()) {
            objects=new JSONArray(tokenizer);
        } else {
            objects=new JSONArray(Collections.singleton(new JSONObject(tokenizer)));
        }
        for(int count=0;count<objects.length();count++) {
            var object=objects.getJSONObject(count);
            var entity=new DynamicTableEntity();
            String entityPartitionKey=getProperty(object,partitionKey);
            entity.setPartitionKey(entityPartitionKey);
            String entityRowKey=getProperty(object,rowKey);
            entity.setRowKey(entityRowKey);
            long millis=System.currentTimeMillis();
            java.util.Date stamp=new java.util.Date(millis);
            entity.setTimestamp(stamp);
            HashMap<String,EntityProperty> properties=new HashMap<String,EntityProperty>();
            if(asObject) {
                properties.put("JsonObject",new EntityProperty(object.toString()));
            } else {
                for(String key : object.keySet()) {
                    properties.put(key,new EntityProperty(getProperty(object,"."+key)));
                }
            }
            entity.setProperties(properties);
            var operation=replace ? TableOperation.insertOrReplace(entity) : TableOperation.insert(entity);
            try {
                var result = cloudTable.execute(operation);
                System.out.println("Successfully "+(replace ? "inserted/replaced" : "inserted")+" entity "+entityRowKey+":"+entityPartitionKey+"@"+tableName+" with status code "+result.getHttpStatusCode());
                inserts++;
            } catch(TableServiceException e) {
                System.out.println("Encountered "+e.getLocalizedMessage()+" when trying to insert entity "+entityRowKey+":"+entityPartitionKey+"@"+tableName);
                e.printStackTrace();
            }
        }
        return inserts;
    }

    /**
     * return a string value for a particular property of object
     * @param object the entity to store
     * @param property either a constant or a property starting with "."
     * @return stringified version of the property, null if the property does not exist
     */
    protected String getProperty(JSONObject object, String property) {
        String result=property;
        if(property!=null && property.startsWith(".")) {
            Object value=object.get(property.substring(1));
            if(value==null) {
                result=null;
            } else {
                result=value.toString();
            }
        }
        return result;
    }

    /** the connection string to the storage account */
    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    /** the file to import */
    public File getJsonFile() {
        return jsonFile;
    }

    public void setJsonFile(File jsonFile) {
        this.jsonFile = jsonFile;
    }

    /** table to fill */
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /** the partition key, if it starts with @ it means that we should look in the data properties */
    public String getPartitionKey() {
        return partitionKey;
    }

    public void setPartitionKey(String partitionKey) {
        this.partitionKey = partitionKey;
    }

    /** the partition key, if it starts with @ it means that we should look in the data properties */
    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    /** whether the entities are stored as objects (inside JsonObject property) or properties */
    public boolean isAsObject() {
        return asObject;
    }

    public void setAsObject(boolean asObject) {
        this.asObject = asObject;
    }

    /**
     * Execute a fill table application
     * @param args Command line syntax:
     *             [Options] inputFiles
     */
    public static void main(String[] args) throws URISyntaxException, IOException, InvalidKeyException, StorageException {
        var fillTable = new FillTable();
        for(int count=0;count<args.length;count++) {
            switch(args[count]) {
                case "-object":
                    fillTable.setAsObject(true);
                    break;
                case "-properties":
                    fillTable.setAsObject(false);
                    break;
                case "-array":
                    fillTable.setAsArray(true);
                    break;
                case "-replace":
                    fillTable.setReplace(true);
                    break;
                case "-insert":
                    fillTable.setReplace(false);
                    break;
                case "-singleton":
                    fillTable.setAsArray(false);
                    break;
                case "+connection":
                    fillTable.setConnectionString(args[++count]);
                    break;
                case "+table":
                    fillTable.setTableName(args[++count]);
                    break;
                case "+partitionKey":
                    fillTable.setPartitionKey(args[++count]);
                    break;
                case "+rowKey":
                    fillTable.setRowKey(args[++count]);
                    break;
                default:
                    fillTable.setJsonFile(new File(args[count]));
                    System.out.println("Inserted "+fillTable.insertData()+" entites from "+args[count]);
                    break;
            }
        }
    }

    /** whether the json file contains an array (or single object) */
    public boolean isAsArray() {
        return asArray;
    }

    public void setAsArray(boolean asArray) {
        this.asArray = asArray;
    }

    /** whether the entities should be replaced */
    public boolean isReplace() {
        return replace;
    }

    public void setReplace(boolean replace) {
        this.replace = replace;
    }
}
