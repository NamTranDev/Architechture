<?xml version="1.0"?>
<recipe>

  	<instantiate 
			from="root/res/layout/base_fragment_mvvm.xml.ftl" 
			to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

	
    <open file="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

    <instantiate from="root/src/app_package/FragmentMvvm.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/${fragmentName}.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/${fragmentName}.java" />

	  <instantiate from="root/src/app_package/FragmentModule.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/${Name}FragmentModule.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/${Name}FragmentModule.java" />

    <instantiate from="root/src/app_package/IViewModel.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/viewmodel/I${Name}ViewModel.java"/>

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/viewmodel/${Name}ViewModel.java" />

    <instantiate from="root/src/app_package/ViewModel.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/viewmodel/${Name}ViewModel.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/viewmodel/I${Name}ViewModel.java" />
	
</recipe>