<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:pwcwc="http://pwc.t-systems.com/pdm/windchill_v02" xmlns:dmc="http://pwc.t-systems.com/datamodel/common">
<!-- 
#
# Copyright (c) 2021 T-Systems International GmbH (Catena-X Consortium)
#
# See the AUTHORS file(s) distributed with this work for additional
# information regarding authorship.
#
# See the LICENSE file(s) distributed with this work for
# additional information regarding license terms.
#
# Sample transformation from DXC to BOM JSON
-->
	<xsl:output method="text" encoding="UTF-8" omit-xml-declaration="yes" indent="no" media-type="application/json" />
	<xsl:strip-space elements="*" />

	<xsl:template match="/">

		<xsl:for-each select="./pwcwc:container/dmc:object">
			<xsl:call-template name="processNode" />
            <xsl:if test="position() != last()">
              <xsl:text>,</xsl:text>
            </xsl:if>

		</xsl:for-each>

	</xsl:template>

	<xsl:template name="processNode">
		<xsl:text>
	{
	"uniqueData" : {
       "customerUniqueID" : "</xsl:text><xsl:call-template name="escape"><xsl:with-param name="text" select="substring-after(./dmc:attribute[@name='obid'],'@')" /></xsl:call-template><xsl:text>",
       "manufacturerUniqueID" : "</xsl:text><xsl:call-template name="escape"><xsl:with-param name="text" select="substring-after(./dmc:attribute[@name='obid'],'@')" /></xsl:call-template><xsl:text>",
       "uniqueID" : "</xsl:text><xsl:call-template name="escape"><xsl:with-param name="text" select="substring-before(./dmc:attribute[@name='obid'],'@')" /></xsl:call-template><xsl:text>"
	},  
	"staticData" : {
       "manufacturerContractOneID" : "T-SYSTEMS/OPEN-SOURCE-PROVISIONING",
       "manufacturerOneID" : "T-SYSTEMS",
       "partNumberManufacturer" : "</xsl:text><xsl:call-template name="escape"><xsl:with-param name="text" select="./dmc:attribute[@name='number']" /></xsl:call-template><xsl:text>",
       "partNameManufacturer" : "</xsl:text><xsl:call-template name="escape"><xsl:with-param name="text" select="./dmc:attribute[@name='name']" /></xsl:call-template><xsl:text>",
       "customerOneID" : "T-SYSTEMS",
       "customerContractOneID" : "T-SYSTEMS/OPEN-SOURCE-CONSUMPTION",
       "partNumberCustomer" : "</xsl:text><xsl:call-template name="escape"><xsl:with-param name="text" select="./dmc:attribute[@name='number']" /></xsl:call-template><xsl:text>",
       "partNameCustomer" : "</xsl:text><xsl:call-template name="escape"><xsl:with-param name="text" select="./dmc:attribute[@name='name']" /></xsl:call-template><xsl:text>"
	},
    "qualityAlertData" : {
      "qualityAlert" : false,
	  "qualityType" : "minor"
    },  
    "individualData" : {
      "productionCountryCode" : "</xsl:text><xsl:call-template name="escape"><xsl:with-param name="text" select="./dmc:attribute[@name='source']" /></xsl:call-template><xsl:text>",
      "productionDateGMT" : "</xsl:text><xsl:call-template name="escape"><xsl:with-param name="text" select="substring-before(./dmc:attribute[@name='thePersistInfo.modifyStamp'],' ')" /></xsl:call-template><xsl:text>"
    },
    "partTree" : {
      "isParentOf" : [</xsl:text>

	  <xsl:for-each select="./dmc:object/dmc:object/dmc:object/dmc:object">
	    <xsl:text>
		{ "src":"", "value":"</xsl:text><xsl:call-template name="escape"><xsl:with-param name="text" select="./dmc:attribute[@name='obid']" /></xsl:call-template><xsl:text>"}</xsl:text>
	    <xsl:if test="position() != last()">
           <xsl:text>,</xsl:text>
        </xsl:if>
	  </xsl:for-each>

	<xsl:text>
	  ]
    },
	"supplierTree" : {
      "isParentOf" : [</xsl:text>

	  <xsl:for-each select="./dmc:object/dmc:object/dmc:object/dmc:object">
	    <xsl:text>
		{ "src":"", "value":"</xsl:text><xsl:call-template name="escape"><xsl:with-param name="text" select="./dmc:attribute[@name='obid']" /></xsl:call-template><xsl:text>"}</xsl:text>
	    <xsl:if test="position() != last()">
           <xsl:text>,</xsl:text>
        </xsl:if>
	  </xsl:for-each>

	<xsl:text>
	  ]
    }

}
</xsl:text>
	</xsl:template>
	
	<!-- Replace characters which could cause an invalid JS object, by their escape-codes. -->
	<xsl:template name="escape">
		<xsl:param name="text" />
		<xsl:param name="char" select="'\'" />
		<xsl:param name="nextChar" select="substring(substring-after('\/&quot;&#xD;&#xA;&#x9;',$char),1,1)" />

		<xsl:choose>
			<xsl:when test="$char = ''">
				<xsl:value-of select="$text" />
			</xsl:when>

			<xsl:when test="contains($text,$char)">
				<xsl:call-template name="escape">
					<xsl:with-param name="text" select="substring-before($text,$char)" />
					<xsl:with-param name="char" select="$nextChar" />
				</xsl:call-template>
				<xsl:value-of select="concat('\',translate($char,'&#xD;&#xA;&#x9;','rnt'))" />
				<xsl:call-template name="escape">
					<xsl:with-param name="text" select="substring-after($text,$char)" />
					<xsl:with-param name="char" select="$char" />
				</xsl:call-template>
			</xsl:when>

			<xsl:otherwise>
				<xsl:call-template name="escape">
					<xsl:with-param name="text" select="$text" />
					<xsl:with-param name="char" select="$nextChar" />
				</xsl:call-template>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
</xsl:stylesheet>