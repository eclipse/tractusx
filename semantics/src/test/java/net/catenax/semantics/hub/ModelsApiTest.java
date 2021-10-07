package net.catenax.semantics.hub;

import java.net.URI;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ModelsApiTest {
    @Autowired
    private MockMvc mvc;

    @Value("${apiversion}")
    private String apiVersion;

    @BeforeAll
    static public void init() {}
    
    @Test
    @Sql("/scripts/init-db.sql")
    public void getModelList() throws Exception {
        mvc.perform(
            MockMvcRequestBuilders.get("/api/" + apiVersion + "/models")
            .accept(MediaType.APPLICATION_JSON)
        )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.content().json("[{'private':false,'id':'urn:bamm:net.catenax:1.0.0#Movement','publisher':'Publisher','version':'1.0.0','name':'Movement','type':'BAMM'}]"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void insertNewValidModel() throws Exception {
        String insertModelJson = "{\"model\": \"@prefix bamm: <urn:bamm:io.openmanufacturing:meta-model:1.0.0#> .\\n @prefix bamm-c: <urn:bamm:io.openmanufacturing:characteristic:1.0.0#> .\\n @prefix bamm-e: <urn:bamm:io.openmanufacturing:entity:1.0.0#> .\\n @prefix unit: <urn:bamm:io.openmanufacturing:unit:1.0.0#> .\\n @prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .\\n @prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> .\\n @prefix xsd: <http://www.w3.org/2001/XMLSchema#> .\\n @prefix : <urn:bamm:net.catenax:1.0.0#> .\\n \\n :TestAspect a bamm:Aspect;\\n bamm:name \\\"TestAspect\\\";\\n bamm:preferredName \\\"TestAspect\\\"@en;\\n bamm:description \\\"Aspect for movement information\\\"@en;\\n bamm:properties (:isMoving :speedLimitWarning :position);\\n bamm:operations ().\\n :isMoving a bamm:Property;\\n bamm:name \\\"isMoving\\\";\\n bamm:preferredName \\\"Moving\\\"@en;\\n bamm:description \\\"Flag indicating whether the asset is currently moving\\\"@en;\\n bamm:characteristic bamm-c:Boolean.\\n :speedLimitWarning a bamm:Property;\\n bamm:name \\\"speedLimitWarning\\\";\\n bamm:preferredName \\\"Speed Limit Warning\\\"@en;\\n bamm:description \\\"Indicates if the speed limit is adhered to.\\\"@en;\\n bamm:characteristic :TrafficLight.\\n :position a bamm:Property;\\n bamm:name \\\"position\\\";\\n bamm:preferredName \\\"Position\\\"@en;\\n bamm:description \\\"Indicates a position\\\"@en;\\n bamm:characteristic :SpatialPositionCharacteristic.\\n :TrafficLight a bamm-c:Enumeration;\\n bamm:name \\\"TrafficLight\\\";\\n bamm:preferredName \\\"Warning Level\\\"@en;\\n bamm:description \\\"Represents if speed of position change is within specification (green), within tolerance (yellow), or outside specification (red).\\\"@en;\\n bamm:dataType xsd:string;\\n bamm-c:values (\\\"green\\\" \\\"yellow\\\" \\\"red\\\").\\n :SpatialPosition a bamm:Entity;\\n bamm:name \\\"SpatialPosition\\\";\\n bamm:preferredName \\\"Spatial Position\\\"@en;\\n bamm:description \\\"Position in space, described along three axis, with the third axis optional, if all positions are in a plane.\\\"@en;\\n bamm:properties (:x :y :z).\\n :x a bamm:Property;\\n bamm:name \\\"x\\\";\\n bamm:preferredName \\\"x\\\"@en;\\n bamm:description \\\"x coordinate in space\\\"@en;\\n bamm:characteristic :Coordinate.\\n :y a bamm:Property;\\n bamm:name \\\"y\\\";\\n bamm:preferredName \\\"y\\\"@en;\\n bamm:description \\\"y coordinate in space\\\"@en;\\n bamm:characteristic :Coordinate.\\n :z a bamm:Property;\\n bamm:name \\\"z\\\";\\n bamm:preferredName \\\"z\\\"@en;\\n bamm:description \\\"z coordinate in space\\\"@en;\\n bamm:characteristic :Coordinate;\\n bamm:optional \\\"true\\\"^^xsd:boolean.\\n :Coordinate a bamm-c:Measurement;\\n bamm:name \\\"Coordinate\\\";\\n bamm:preferredName \\\"Coordinate\\\"@en;\\n bamm:description \\\"Represents a coordinate along an axis in space.\\\"@en;\\n bamm:dataType xsd:float;\\n bamm-c:unit unit:metre.\\n :SpatialPositionCharacteristic a bamm-c:SingleEntity;\\n bamm:name \\\"SpatialPositionCharacteristic\\\";\\n bamm:preferredName \\\"Spatial Position Characteristic\\\"@en;\\n bamm:description \\\"Represents a single position in space with optional z coordinate.\\\"@en;\\n bamm:dataType :SpatialPosition.\\n\",\"private\": false,\"type\": \"BAMM\"}";

        mvc.perform(
            MockMvcRequestBuilders.post("/api/" + apiVersion + "/models")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .content(insertModelJson)
        )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.content().json("{\"private\":false,\"id\":\"urn:bamm:net.catenax:1.0.0#TestAspect\",\"publisher\":null,\"version\":\"1.0.0\",\"name\":\"TestAspect\",\"type\":\"BAMM\"}"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void insertNewInvalidModel() throws Exception {
        String insertModelJson = "{\"model\": \"@prefix bamm: <urn:bamm:io.openmanufacturing:meta-model:1.0.0#> .\\n @prefix bamm-c: <urn:bamm:io.openmanufacturing:characteristic:1.0.0#> .\\n @prefix bamm-e: <urn:bamm:io.openmanufacturing:entity:1.0.0#> .\\n @prefix unit: <urn:bamm:io.openmanufacturing:unit:1.0.0#> .\\n @prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .\\n @prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> .\\n @prefix xsd: <http://www.w3.org/2001/XMLSchema#> .\\n @prefix : <urn:bamm:net.catenax:1.0.0#> .\\n \\n :Movement a bamm:Aspect;\\n bamm:name \\\"Movement\\\";\\n bamm:preferredName \\\"Movement\\\"@en;\\n bamm:description \\\"Aspect for movement information\\\"@en;\\n bamm:propertiesX (:isMoving :speedLimitWarning :position);\\n bamm:operations ().\\n :isMoving a bamm:Property;\\n bamm:name \\\"isMoving\\\";\\n bamm:preferredName \\\"Moving\\\"@en;\\n bamm:description \\\"Flag indicating whether the asset is currently moving\\\"@en;\\n bamm:characteristic bamm-c:Boolean.\\n :speedLimitWarning a bamm:Property;\\n bamm:name \\\"speedLimitWarning\\\";\\n bamm:preferredName \\\"Speed Limit Warning\\\"@en;\\n bamm:description \\\"Indicates if the speed limit is adhered to.\\\"@en;\\n bamm:characteristic :TrafficLight.\\n :position a bamm:Property;\\n bamm:name \\\"position\\\";\\n bamm:preferredName \\\"Position\\\"@en;\\n bamm:description \\\"Indicates a position\\\"@en;\\n bamm:characteristic :SpatialPositionCharacteristic.\\n :TrafficLight a bamm-c:Enumeration;\\n bamm:name \\\"TrafficLight\\\";\\n bamm:preferredName \\\"Warning Level\\\"@en;\\n bamm:description \\\"Represents if speed of position change is within specification (green), within tolerance (yellow), or outside specification (red).\\\"@en;\\n bamm:dataType xsd:string;\\n bamm-c:values (\\\"green\\\" \\\"yellow\\\" \\\"red\\\").\\n :SpatialPosition a bamm:Entity;\\n bamm:name \\\"SpatialPosition\\\";\\n bamm:preferredName \\\"Spatial Position\\\"@en;\\n bamm:description \\\"Position in space, described along three axis, with the third axis optional, if all positions are in a plane.\\\"@en;\\n bamm:properties (:x :y :z).\\n :x a bamm:Property;\\n bamm:name \\\"x\\\";\\n bamm:preferredName \\\"x\\\"@en;\\n bamm:description \\\"x coordinate in space\\\"@en;\\n bamm:characteristic :Coordinate.\\n :y a bamm:Property;\\n bamm:name \\\"y\\\";\\n bamm:preferredName \\\"y\\\"@en;\\n bamm:description \\\"y coordinate in space\\\"@en;\\n bamm:characteristic :Coordinate.\\n :z a bamm:Property;\\n bamm:name \\\"z\\\";\\n bamm:preferredName \\\"z\\\"@en;\\n bamm:description \\\"z coordinate in space\\\"@en;\\n bamm:characteristic :Coordinate;\\n bamm:optional \\\"true\\\"^^xsd:boolean.\\n :Coordinate a bamm-c:Measurement;\\n bamm:name \\\"Coordinate\\\";\\n bamm:preferredName \\\"Coordinate\\\"@en;\\n bamm:description \\\"Represents a coordinate along an axis in space.\\\"@en;\\n bamm:dataType xsd:float;\\n bamm-c:unit unit:metre.\\n :SpatialPositionCharacteristic a bamm-c:SingleEntity;\\n bamm:name \\\"SpatialPositionCharacteristic\\\";\\n bamm:preferredName \\\"Spatial Position Characteristic\\\"@en;\\n bamm:description \\\"Represents a single position in space with optional z coordinate.\\\"@en;\\n bamm:dataType :SpatialPosition.\\n\",\"private\": false,\"type\": \"BAMM\"}";

        mvc.perform(
            MockMvcRequestBuilders.post("/api/" + apiVersion + "/models")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .content(insertModelJson)
        )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.content().string("[resultMessage:  Property needs to have at least 1 values, but found 0\nfocusNode:      urn:bamm:net.catenax:1.0.0#Movement\nresultPath:     urn:bamm:io.openmanufacturing:meta-model:1.0.0#properties\nresultSeverity: http://www.w3.org/ns/shacl#Violation\nvalue:          \n]"))
        .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void generateJsonSchema() throws Exception {
        mvc.perform(
            MockMvcRequestBuilders.get(new URI("%2Fapi%2F" + apiVersion + "/models/urn%3Abamm%3Anet.catenax%3A1.0.0%23Movement/json-schema"))
        )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.content().json("{\"$schema\":\"http://json-schema.org/draft-04/schema\",\"type\":\"object\",\"components\":{\"schemas\":{\"urn_bamm_io.openmanufacturing_characteristic_1.0.0_Boolean\":{\"type\":\"boolean\"},\"urn_bamm_net.catenax_1.0.0_TrafficLight\":{\"type\":\"string\",\"enum\":[\"green\",\"yellow\",\"red\"]},\"urn_bamm_net.catenax_1.0.0_Coordinate\":{\"type\":\"number\"},\"urn_bamm_net.catenax_1.0.0_SpatialPositionCharacteristic\":{\"type\":\"object\",\"properties\":{\"x\":{\"$ref\":\"#/components/schemas/urn_bamm_net.catenax_1.0.0_Coordinate\"},\"y\":{\"$ref\":\"#/components/schemas/urn_bamm_net.catenax_1.0.0_Coordinate\"},\"z\":{\"$ref\":\"#/components/schemas/urn_bamm_net.catenax_1.0.0_Coordinate\"}},\"required\":[\"x\",\"y\",\"z\"]}}},\"properties\":{\"isMoving\":{\"$ref\":\"#/components/schemas/urn_bamm_io.openmanufacturing_characteristic_1.0.0_Boolean\"},\"speedLimitWarning\":{\"$ref\":\"#/components/schemas/urn_bamm_net.catenax_1.0.0_TrafficLight\"},\"position\":{\"$ref\":\"#/components/schemas/urn_bamm_net.catenax_1.0.0_SpatialPositionCharacteristic\"}},\"required\":[\"isMoving\",\"speedLimitWarning\",\"position\"]}"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
}