<?xml version="1.0"?>
<recipe>

  <merge from="root/AndroidManifest.xml.ftl"
             to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />

  <open file="${escapeXmlAttribute(srcOut)}/AndroidManifest.xml" />

  <instantiate from="root/src/app_package/BaseActivityWithFragment.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/view/${funtionName}/${activityName}.java" />

  <open file="${escapeXmlAttribute(srcOut)}/${funtionName}/${activityName}.java" />

  <instantiate 
			from="root/res/layout/base_activity_with_fragment.xml.ftl" 
			to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

	
  <open file="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />
  
  <instantiate from="root/src/app_package/ActivityModule.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${funtionName}/${Name}ActivityModule.java" />

  <open file="${escapeXmlAttribute(srcOut)}/view/${funtionName}/${Name}ActivityModule.java" />

  <merge from="root/settings.gradle.ftl"
             to="${escapeXmlAttribute(topOut)}/settings.gradle" />

  <merge from="root/build.gradle.ftl"
             to="${escapeXmlAttribute(projectOut)}/build.gradle" />

  <instantiate from="root/src/app_package/AppState.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/view/AppState.java" />

  <instantiate from="root/src/app_package/NavigatorApp.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/view/NavigatorApp.java" />

  <instantiate from="root/src/app_package/NavigatorApp.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/view/NavigatorApp.java" />

  <instantiate from="root/src/app_package/AppComponent.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/di/component/AppComponent.java" />

  <instantiate from="root/src/app_package/AppModule.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/di/module/AppModule.java" />

  <instantiate from="root/src/app_package/ViewModelModule.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/di/module/ViewModelModule.java" />

  <instantiate from="root/src/app_package/DataMapper.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/mapper/DataMapper.java" />

  <instantiate from="root/src/app_package/PreferenceMapper.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/mapper/PreferenceMapper.java" />

  <instantiate from="root/src/app_package/PreferenceModel.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/model/PreferenceModel.java" />

  <instantiate from="root/src/app_package/SplashActivity.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/view/splash/SplashActivity.java" />

  <instantiate from="root/src/app_package/SplashActivityModule.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/view/splash/SplashActivityModule.java" />

  <instantiate 
			from="root/res/layout/activity_splash.xml.ftl" 
			to="${escapeXmlAttribute(resOut)}/layout/activity_splash.xml" />

</recipe>