<?xml version="1.0"?>
<recipe>

  	<instantiate 
			from="root/res/layout/base_fragment_mvvm.xml.ftl" 
			to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

	
    <open file="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

    <instantiate from="root/src/app_package/FragmentMvvm.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${fragmentName}.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${fragmentName}.kt" />

    <#if isViewModel>
	  <instantiate from="root/src/app_package/FragmentModule.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${Name}Module.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${Name}Module.kt" />
    </#if>

    <#if isViewModel>
    <instantiate from="root/src/app_package/ViewModel.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${Name}ViewModel.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${Name}ViewModel.kt" />
    </#if>
	
</recipe>