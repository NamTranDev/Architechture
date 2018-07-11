<?xml version="1.0" encoding="utf-8"?>
<#if hasBiding>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="view"
            type="${packageName}.${funtionName}.${fragmentName}"/>
    </data>

    <android.support.constraint.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="${packageName}.${funtionName}.${fragmentName}">
        
    </android.support.constraint.ConstraintLayout>

</layout>
<#else>
	<android.support.constraint.ConstraintLayout
		xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
    	xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="${packageName}.${funtionName}.${fragmentName}">
        
    </android.support.constraint.ConstraintLayout>
</#if>