<?xml version="1.0"?>
<globals>
	<global id="useSupport" type="boolean" value="${(minApiLevel lt 19)?string}" />
    <global id="resOut" value="${resDir}" />
    <global id="srcOut" value="${srcDir}/${slashedPackageName(packageName)}" />
    <global id="relativePackage" value="<#if relativePackage?has_content>${relativePackage}<#else>${packageName}</#if>" />

    <#include "root://gradle-projects/common/globals.xml.ftl" />
    <#include "root://gradle-projects/common/globals_android_module.xml.ftl" />
    <#include "root://activities/common/kotlin_globals.xml.ftl" />
</globals>