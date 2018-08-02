<?xml version="1.0"?>
<recipe>

	<merge from="root/AndroidManifest.xml.ftl"
             to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />

    <open file="${escapeXmlAttribute(srcOut)}/AndroidManifest.xml" />

	  <instantiate from="root/src/app_package/BaseActivityWithFragment.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/${activityName}.java" />

  	<open file="${escapeXmlAttribute(srcOut)}/${funtionName}/${activityName}.java" />

  	<instantiate 
			from="root/res/layout/base_activity_with_fragment.xml.ftl" 
			to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

	
    <open file="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

  
	  <instantiate from="root/src/app_package/ActivityModule.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/${Name}ActivityModule.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/${Name}ActivityModule.java" />
   
	
</recipe>