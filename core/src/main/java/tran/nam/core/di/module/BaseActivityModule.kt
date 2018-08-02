package tran.nam.core.di.module

import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity

import javax.inject.Named

import dagger.Binds
import dagger.Module
import dagger.Provides
import tran.nam.core.di.inject.PerActivity

/**
 * Provides base activity dependencies. This must be included in all activity modules, which must
 * provide a concrete implementation of [AppCompatActivity].
 */
@Module
abstract class BaseActivityModule {

    companion object {
        const val ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager"
    }

    @Binds
    @PerActivity
    /*
     * PerActivity annotation isn't necessary since Activity instance is unique but is here for
     * convention. In general, providing Application, Activity, Fragment, BroadcastReceiver,
     * etc does not require scoped annotations since they are the components being injected and
     * their instance is unique.
     *
     * However, having a scope annotation makes the module easier to read. We wouldn't have to look
     * at what is being provided in order to understand its scope.
     */
    internal abstract fun activityContext(activity: AppCompatActivity): Context

    @Provides
    @Named(ACTIVITY_FRAGMENT_MANAGER)
    @PerActivity
    internal fun activityFragmentManager(activity: AppCompatActivity): FragmentManager {
        return activity.supportFragmentManager
    }
}