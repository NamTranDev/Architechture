<?xml version="1.0"?>
<recipe>

    <instantiate from="src/app_package/DataMapper.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${DataMapperName}.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${DataMapperName}.kt" />
	
</recipe>