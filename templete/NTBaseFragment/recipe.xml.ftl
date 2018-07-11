<?xml version="1.0"?>
<recipe>

  	<instantiate 
			from="root/res/layout/fragment_base.xml.ftl" 
			to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

	
    <open file="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

    <instantiate from="root/src/app_package/FragmentBase.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/${fragmentName}.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/${fragmentName}.java" />

    <#if hasInject>
	  <instantiate from="root/src/app_package/FragmentModule.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/${Name}FragmentModule.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/${Name}FragmentModule.java" />
    </#if>
	
</recipe>