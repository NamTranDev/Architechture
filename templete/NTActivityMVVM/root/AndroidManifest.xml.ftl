<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
	xmlns:tools="http://schemas.android.com/tools"
	<#if applicationPackage??>
		package="${applicationPackage}"
</#if>>
  <application
      >
    <activity 
        android:name="${relativePackage}.${funtionName}.${activityName}" />
  </application>
</manifest>