package nam.tran.architechture.view.splash

import androidx.fragment.app.Fragment

import dagger.Binds
import dagger.Module
import tran.nam.core.di.inject.PerFragment

/**
 * Provides splash fragment dependencies.
 */
@Module
abstract class SplashFragmentModule {

    @Binds
    @PerFragment
    internal abstract fun fragment(fragment: SplashFragment): Fragment
}
