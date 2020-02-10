package ${packageName}

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Provides ${classToResource(fragmentName)?replace('_', ' ')} fragment dependencies.
 */
@Module(includes = [${Name}Module.ProvideViewModel::class])
abstract class ${Name}Module {

    @ContributesAndroidInjector(modules = [InjectViewModel::class])
    abstract fun bind(): ${fragmentName}

    @Module
    class ProvideViewModel {

        @Provides
        @IntoMap
        @ViewModelKey(${Name}ViewModel::class)
        fun provideViewModel(): ViewModel =
            ${Name}ViewModel()
    }

    @Module
    class InjectViewModel {
        @Provides
        fun provideViewModel(
            factory: ViewModelProvider.Factory,
            target: ${fragmentName}
        ) =
            ViewModelProviders.of(target, factory).get(${Name}ViewModel::class.java)
    }
}

