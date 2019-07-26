package nam.tran.architechture.view.event

import androidx.fragment.app.Fragment

import dagger.Binds
import dagger.Module
import tran.nam.core.di.inject.PerChildFragment

/**
 * Provides events fragment dependencies.
 */
@Module
abstract class EventsFragmentModule {

    @Binds
    @PerChildFragment
    internal abstract fun fragmentInject(fragment: EventsFragment): Fragment
}
