package nam.tran.architechture.view.home

import androidx.fragment.app.Fragment

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import nam.tran.architechture.view.event.EventsFragment
import nam.tran.architechture.view.event.EventsFragmentModule
import nam.tran.architechture.view.repository.RepositoriesFragment
import nam.tran.architechture.view.repository.RepositoriesFragmentModule
import nam.tran.architechture.view.user.UserFragment
import nam.tran.architechture.view.user.UserFragmentModule
import tran.nam.core.di.inject.PerChildFragment
import tran.nam.core.di.inject.PerFragment

/**
 * Provides home fragment dependencies.
 */
@Module
abstract class HomeFragmentModule {

    @Binds
    @PerFragment
    internal abstract fun fragment(fragment: HomeFragment): Fragment

    /**
     * Provides the injector for the [EventsFragmentModule], which has access to the
     * dependencies provided by this fragment and activity and application instance
     * (singleton scoped objects).
     */
    @PerChildFragment
    @ContributesAndroidInjector(modules = [EventsFragmentModule::class])
    internal abstract fun injectorEventsFragment(): EventsFragment

    /**
     * Provides the injector for the [RepositoriesFragmentModule], which has access to the
     * dependencies provided by this fragment and activity and application instance
     * (singleton scoped objects).
     */
    @PerChildFragment
    @ContributesAndroidInjector(modules = [RepositoriesFragmentModule::class])
    internal abstract fun injectorRepositoriesFragment(): RepositoriesFragment

    /**
     * Provides the injector for the [UserFragmentModule], which has access to the
     * dependencies provided by this fragment and activity and application instance
     * (singleton scoped objects).
     */
    @PerChildFragment
    @ContributesAndroidInjector(modules = [UserFragmentModule::class])
    internal abstract fun injectorUserFragment(): UserFragment
}
