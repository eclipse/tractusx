<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:pwcwc="http://pwc.t-systems.com/pdm/windchill_v02" xmlns:dmc="http://pwc.t-systems.com/datamodel/common">
<!-- 
#
# Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
#
# See the AUTHORS file(s) distributed with this work for additional
# information regarding authorship.
#
# See the LICENSE file(s) distributed with this work for
# additional information regarding license terms.
#
# Transformation of relational data into digital twin registration
-->
	<xsl:output method="text" encoding="UTF-8"  omit-xml-declaration="yes" indent="no" media-type="application/json" />
	<xsl:strip-space elements="*" />

	<xsl:param name="CONNECTOR_PROTOCOL"/>
	<xsl:param name="CONNECTOR_HOST"/>

	<xsl:template match="/">
      <xsl:text>[
	  </xsl:text>
	  <xsl:for-each select="./DataSets/parts/Row">
	     <xsl:text>{
  	"description": [
    	{
      		"language": "en",
      		"text": "</xsl:text><xsl:value-of select="./DESCRIPTION"/><xsl:text>"
		}
  	],
  	"globalAssetId": {
    	"value": [
      		"urn:twin:com.</xsl:text><xsl:value-of select="./MANUFACTURER"/><xsl:text>#</xsl:text><xsl:value-of select="./UUID"/><xsl:text>"
    	]
  	},
  	"idShort": "</xsl:text><xsl:value-of select="./DESCRIPTION"/><xsl:text>",
  	"identification": "urn:twin:com.</xsl:text><xsl:value-of select="./MANUFACTURER"/><xsl:text>#</xsl:text><xsl:value-of select="./UUID"/><xsl:text>",
  	"specificAssetIds": [
        </xsl:text><xsl:if test="./CUSTOMER = 'VIN'"><xsl:text>{
          		"key": "urn:VAN:com.bmw:1.0.0#",
           		"value": "</xsl:text><xsl:value-of select="./CUSTOMERNUMBER"/><xsl:text>"
        },</xsl:text></xsl:if><xsl:text>
        {
           		"key": "urn:serial:com.</xsl:text><xsl:choose><xsl:when test="./CUSTOMER = 'VIN'"><xsl:value-of select="./MANUFACTURER"/></xsl:when><xsl:otherwise><xsl:value-of select="./CUSTOMER"/></xsl:otherwise></xsl:choose><xsl:text>:part-serial",
           		"value": "</xsl:text><xsl:value-of select="./PARTSERIAL"/><xsl:text>"
        },
		{
           		"key": "urn:part:com.</xsl:text><xsl:value-of select="./MANUFACTURER"/><xsl:text>:part-number",
           		"value": "</xsl:text><xsl:value-of select="./PARTNUMBER"/><xsl:text>"
        }
  	],
  	"submodelDescriptors": [
    	{
      		"description": [
        		{
          			"language": "en",
          			"text": "Catena-X Traceability Aspect Implementation"
        		}
      		],
      		"idShort": "sql-traceability",
      		"identification": "traceability-aspect",
      		"semanticId": {
        		"value": [
          			"urn:bamm:com.catenaX:0.0.1#Traceability"
        		]
      		},
      		"endpoints": [
		    	{
                    "interface": "SUBMODEL-1.0RC02",
          			"protocolInformation": {
		                 "endpointAddress": "</xsl:text><xsl:value-of select="$CONNECTOR_PROTOCOL"/><xsl:text>://</xsl:text><xsl:value-of select="$CONNECTOR_HOST"/><xsl:text>/offer-tdm/shells/</xsl:text><xsl:value-of select="./UUID"/><xsl:text>/aas/traceability-aspect/submodel?manufacturer=</xsl:text><xsl:value-of select="./MANUFACTURER"/><xsl:text disable-output-escaping="yes">&amp;serial=</xsl:text><xsl:value-of select="./PARTSERIAL"/><xsl:text disable-output-escaping="yes">&amp;artifact=bom-vehicle&amp;level=deep&amp;content=value&amp;extent=withBlobValue",
                         "endpointProtocol": "IDS/ECLIPSE DATASPACE CONNECTOR",
                         "endpointProtocolVersion": "0.0.1-SNAPSHOT"
          			}
        		}
      		]
		},
    	{
      		"description": [
        		{
          			"language": "en",
          			"text": "Catena-X Material Aspect Implementation"
        		}
      		],
      		"idShort": "sql-material",
      		"identification": "material-aspect",
      		"semanticId": {
        		"value": [
          			"urn:bamm:com.catenaX:0.0.1#Material"
        		]
      		},
		    "endpoints": [
        		{
                    "interface": "SUBMODEL-1.0RC02",
         			"protocolInformation": {
		  				"endpointAddress": "</xsl:text><xsl:value-of select="$CONNECTOR_PROTOCOL"/><xsl:text>://</xsl:text><xsl:value-of select="$CONNECTOR_HOST"/><xsl:text>/offer-tdm/shells/</xsl:text><xsl:value-of select="./UUID"/><xsl:text>/aas/material-aspect/submodel?manufacturer=</xsl:text><xsl:value-of select="./MANUFACTURER"/><xsl:text disable-output-escaping="yes">&amp;amp;number=</xsl:text><xsl:value-of select="./PARTNUMBER"/><xsl:text disable-output-escaping="yes">&amp;artifact=material-vehicle&amp;level=deep&amp;content=value&amp;extent=withBlobValue",
                        "endpointProtocol": "IDS/ECLIPSE DATASPACE CONNECTOR",
                        "endpointProtocolVersion": "0.0.1-SNAPSHOT"
          			}
        		}
      		]
    	}
  	]
  }
</xsl:text>
  		 <xsl:if test="position() != last()">
           <xsl:text>,</xsl:text>
         </xsl:if>
	  </xsl:for-each>
      <xsl:text>
]</xsl:text>
    </xsl:template>

</xsl:stylesheet>