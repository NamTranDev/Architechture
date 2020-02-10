<?xml version="1.0" encoding="utf-8"?>
<#if isViewModel>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="viewModel"
            type="${packageName}.${Name}ViewModel"/>
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="${packageName}.${fragmentName}">

        <#if isLoading>
        <include
            layout="@layout/loading_state"
            app:state="@{viewModel.status}" />
        </#if>
    </androidx.constraintlayout.widget.ConstraintLayout>

</layout>
</#if>

<#if hasBiding && !isViewModel>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="view"
            type="${packageName}.${fragmentName}"/>
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="${packageName}.${fragmentName}">
        
    </androidx.constraintlayout.widget.ConstraintLayout>

</layout>
<#elseif !isViewModel>
    <androidx.constraintlayout.widget.ConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="${packageName}.${fragmentName}">
        
    </androidx.constraintlayout.widget.ConstraintLayout>
</#if>