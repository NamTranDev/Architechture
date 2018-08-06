package nam.tran.architechture.di.module

import android.app.Application

import javax.inject.Singleton

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import nam.tran.architechture.view.AppState
import nam.tran.architechture.view.main.MainActivity
import nam.tran.architechture.view.main.MainActivityModule
import nam.tran.architechture.view.main.activity.TestTempleteActivity
import nam.tran.architechture.view.main.activity.TestTempleteActivityModule
import nam.tran.architechture.view.main.activity.team.TeamActivity
import nam.tran.architechture.view.main.activity.team.TeamActivityModule
import nam.tran.architechture.view.main.fragment.TestFragmentTempleteActivity
import nam.tran.architechture.view.main.fragment.TestFragmentTempleteActivityModule
import nam.tran.domain.di.DataModule
import tran.nam.core.di.inject.PerActivity

/**
 * Provides application-wide dependencies.
 */
@Module(includes = arrayOf(AndroidSupportInjectionModule::class, ViewModelModule::class, DataModule::class))
abstract class AppModule {

    @Binds
    @Singleton
    internal abstract/*
     * Singleton annotation isn't necessary since Application instance is unique but is here for
     * convention. In general, providing Activity, Fragment, BroadcastReceiver, etc does not require
     * them to be scoped since they are the components being injected and their instance is unique.
     *
     * However, having a scope annotation makes the module easier to read. We wouldn't have to look
     * at what is being provided in order to understand its scope.
     */ fun application(app: AppState): Application

    /**
     * Provides the injector for the [MainActivityModule], which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    internal abstract fun MainActivityInjector(): MainActivity

    /**
     * Provides the injector for the [TestTempleteActivityModule], which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(TestTempleteActivityModule::class))
    internal abstract fun injectorTestTempleteActivity(): TestTempleteActivity

    /**
     * Provides the injector for the [TeamActivityModule], which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(TeamActivityModule::class))
    internal abstract fun injectorTeamActivity(): TeamActivity

    /**
     * Provides the injector for the [TestFragmentTempleteActivityModule], which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(TestFragmentTempleteActivityModule::class))
    internal abstract fun injectorTestFragmentTempleteActivity(): TestFragmentTempleteActivity
}
