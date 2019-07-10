<?xml version="1.0" encoding="utf-8"?>
<#if isViewModel || isViewModelLoading>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="viewModel"
            type="${packageName}.${funtionName}.viewmodel.${Name}ViewModel"/>
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="${packageName}.${funtionName}.${activityName}">

        <#if isViewModelLoading>
        <include
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            layout="@layout/loading_state"
            app:resource="@{viewModel.resource()}"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent" />
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
            type="${packageName}.${funtionName}.${activityName}"/>
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="${packageName}.${funtionName}.${activityName}">
        
    </androidx.constraintlayout.widget.ConstraintLayout>

</layout>
<#elseif !isViewModel && !isViewModelLoading>
    <androidx.constraintlayout.widget.ConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="${packageName}.${funtionName}.${activityName}">
        
    </androidx.constraintlayout.widget.ConstraintLayout>
</#if>