package ${packageName}.${funtionName}

import androidx.fragment.app.Fragment

import javax.inject.Named

import dagger.Binds
import dagger.Module
import tran.nam.core.di.inject.PerFragment

/**
 * Provides ${classToResource(fragmentName)?replace('_', ' ')} fragment dependencies.
 */
@Module
abstract class ${Name}FragmentModule {

    @Binds
    @PerFragment
    internal abstract fun fragment(fragment: ${fragmentName}): Fragment
}
