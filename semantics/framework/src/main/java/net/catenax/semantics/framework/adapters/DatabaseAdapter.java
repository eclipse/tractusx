/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework.adapters;

import java.sql.*;
import java.util.Map;
import java.util.stream.Collectors;

import net.catenax.semantics.framework.*;
import net.catenax.semantics.framework.config.*;
import org.springframework.stereotype.Service;

/**
 * A backend adapter sitting on a database
 */
@Service
public class DatabaseAdapter<Cmd extends Command, O extends Offer, Ct extends Catalog, Co extends Contract, T extends Transformation> extends BaseAdapter<Cmd,O,Ct,Co,T> implements BackendAdapter {

    private final javax.sql.DataSource defaultDataSource;

    /**
     * creates a new database adapter
     * @param configurationData
     */
    public DatabaseAdapter(Config<Cmd,O,Ct,Co,T> configurationData, javax.sql.DataSource defaultDataSource) {
        super(configurationData);
        this.defaultDataSource=defaultDataSource;
    }

    @Override
    public String getProtocol() {
        return "SQL";
    }

    @Override
    public IdsMessage perform(IdsRequest request, String model) throws StatusException {
        BaseIdsMessage responseMessage=new BaseIdsMessage();
        responseMessage.setMediaType("text/xml");
        responseMessage.setModel("urn:com:tsystems:DataSet");
        Command command = configurationData.getCommands().get(request.getCommand());

        // load jdbc stuff
        try (final Connection fconn = getConnection(command)) {
            log.info("using configured DataSource Connection: " + fconn.toString());
            Map<String, ResultSet> resultSets = command.getAliases().entrySet()
                    .stream().collect(Collectors.toMap(alias -> alias.getKey(), alias -> {
                        try {
                            Statement stmt = fconn.createStatement();
                            String sql = alias.getValue();
                            for (Map.Entry<String, String> param : request.getParameters().entrySet()) {
                                sql = sql.replace("{" + param.getKey() + "}", param.getValue().replace("+", "%2b"));
                            }
                            log.info(sql);
                            return (ResultSet) stmt.executeQuery(sql);
                        } catch (SQLException e) {
                            log.error("handle jdbc source",e);
                            return null;
                        }
                    }));
            responseMessage.setPayload(convert(resultSets));
        } catch (SQLException | ClassNotFoundException e) {
            throw new StatusException("error processing sql",e);
        }
        return responseMessage;
    }

    /**
     * access the datasource associated to a source
     * @param so the source rep
     * @return the datasource associated
     */
    protected Connection getConnection(Command so) throws ClassNotFoundException, SQLException {
        if (so.getDatasource() != null
                && so.getDatasource().getDriverClassName() != null
                && so.getDatasource().getDriverClassName().length() > 0) {
            DataSource ds = so.getDatasource();
            Class connClass = Class.forName(ds.getDriverClassName());
            return DriverManager.getConnection(ds.getUrl(), ds.getUsername(), ds.getPassword());
        } else {
            return defaultDataSource.getConnection();
        }
    }

    /**
     * converts a given resultset mapping into a XSLT source
     * @param specs a map of aliases to result sets
     * @return XML text
     */
    public String convert(Map<String,ResultSet> specs) throws SQLException {
        StringBuilder document = new StringBuilder();
        document.append("<DataSets>");

        for (Map.Entry<String, ResultSet> dataSet : specs.entrySet()) {
            if (dataSet.getValue() != null) {
                document.append("<");
                document.append(dataSet.getKey());
                document.append(">");
                ResultSetMetaData rsmd = dataSet.getValue().getMetaData();
                int colCount = rsmd.getColumnCount();
                while (dataSet.getValue().next()) {
                    document.append("<Row>");
                    for (int count = 1; count <= colCount; count++) {
                        String columnName = rsmd.getColumnLabel(count).toUpperCase();
                        Object value = dataSet.getValue().getObject(count);
                        if (!dataSet.getValue().wasNull()) {
                            document.append("<");
                            document.append(columnName);
                            document.append(">");
                            document.append("<![CDATA[");
                            document.append(value.toString());
                            document.append("]]>");
                            document.append("</");
                            document.append(columnName);
                            document.append(">");
                        }
                    } // for col
                    document.append("</Row>");
                } // while rs.next()
                dataSet.getValue().close();
                document.append("</");
                document.append(dataSet.getKey());
                document.append(">");
            }
        } // for dataSet
        document.append("</DataSets>");

        return document.toString();
    }

}
