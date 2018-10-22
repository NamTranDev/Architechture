<?xml version="1.0"?>
<recipe>

  	<instantiate 
			from="root/res/layout/base_fragment_mvvm.xml.ftl" 
			to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

	
    <open file="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

    <instantiate from="root/src/app_package/FragmentMvvm.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/${fragmentName}.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/${fragmentName}.kt" />

	  <instantiate from="root/src/app_package/FragmentModule.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/${Name}FragmentModule.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/${Name}FragmentModule.kt" />

    <instantiate from="root/src/app_package/IViewModel.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/viewmodel/I${Name}ViewModel.kt"/>

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/viewmodel/${Name}ViewModel.kt" />

    <instantiate from="root/src/app_package/ViewModel.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/viewmodel/${Name}ViewModel.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/viewmodel/I${Name}ViewModel.kt" />
	
</recipe>