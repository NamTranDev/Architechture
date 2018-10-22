<?xml version="1.0"?>
<recipe>

  	<instantiate 
			from="root/res/layout/fragment_base.xml.ftl" 
			to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

	
    <open file="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

    <instantiate from="root/src/app_package/FragmentBase.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/${fragmentName}.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/${fragmentName}.kt" />

    <#if hasInject>
	  <instantiate from="root/src/app_package/FragmentModule.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/${Name}FragmentModule.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/${Name}FragmentModule.kt" />
    </#if>
	
</recipe>