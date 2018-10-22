<?xml version="1.0" encoding="utf-8"?>
<#if hasBiding>
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="view"
            type="${packageName}.${funtionName}.${fragmentName}"/>
    </data>

    <FrameLayout
        android:id="@+id/${layoutName?replace('fragment_', '')}_contain"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</layout>
<#else>
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/${layoutName?replace('fragment_', '')}_contain"/>
</#if>