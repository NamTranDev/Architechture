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

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="${packageName}.${funtionName}.${fragmentName}">
        
    </androidx.constraintlayout.widget.ConstraintLayout>

</layout>
<#else>
	<androidx.constraintlayout.widget.ConstraintLayout
		xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
    	xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="${packageName}.${funtionName}.${fragmentName}">
        
    </androidx.constraintlayout.widget.ConstraintLayout>
</#if>