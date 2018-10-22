<?xml version="1.0"?>
<recipe>

	<merge from="root/AndroidManifest.xml.ftl"
             to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />

    <open file="${escapeXmlAttribute(srcOut)}/AndroidManifest.xml" />

	<instantiate from="root/src/app_package/BaseActivity.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/${activityName}.kt" />

  	<open file="${escapeXmlAttribute(srcOut)}/${funtionName}/${activityName}.kt" />

  	<instantiate 
			from="root/res/layout/base_activity.xml.ftl" 
			to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

	
    <open file="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

    <#if hasInject>
	<instantiate from="root/src/app_package/ActivityModule.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/${Name}ActivityModule.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/${Name}ActivityModule.kt" />
    </#if>
	
</recipe>