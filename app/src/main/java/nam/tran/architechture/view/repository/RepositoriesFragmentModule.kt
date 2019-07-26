package nam.tran.architechture.view.repository

import androidx.fragment.app.Fragment

import dagger.Binds
import dagger.Module
import tran.nam.core.di.inject.PerChildFragment

/**
 * Provides repositories fragment dependencies.
 */
@Module
abstract class RepositoriesFragmentModule {

    @Binds
    @PerChildFragment
    internal abstract fun fragmentInject(fragment: RepositoriesFragment): Fragment
}
