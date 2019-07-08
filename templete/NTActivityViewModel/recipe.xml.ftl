<?xml version="1.0"?>
<recipe>

	  <merge from="root/AndroidManifest.xml.ftl"
             to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />

    <open file="${escapeXmlAttribute(srcOut)}/AndroidManifest.xml" />

	  <instantiate 
        from="root/res/layout/base_activity_mvvm.xml.ftl" 
        to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

    <open file="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

    <instantiate from="root/src/app_package/BaseActivityMvvm.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/${activityName}.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/${activityName}.kt" />
  
  	<#if hasInject || isViewModel || isViewModelLoading>

	<instantiate from="root/src/app_package/ActivityModule.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/${Name}ActivityModule.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/${Name}ActivityModule.kt" />

    </#if>

    <#if isViewModel || isViewModelLoading>
    <instantiate from="root/src/app_package/ViewModel.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/viewmodel/${Name}ViewModel.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/viewmodel/${Name}ViewModel.kt" />
    </#if>
	
</recipe>