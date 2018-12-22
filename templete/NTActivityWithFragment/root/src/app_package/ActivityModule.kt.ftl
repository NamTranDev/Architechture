package ${packageName}.${funtionName}

import androidx.appcompat.app.AppCompatActivity

import dagger.Binds
import dagger.Module
import tran.nam.core.di.inject.PerActivity

import tran.nam.core.view.BaseFragment
import tran.nam.core.view.IFragmentProvider
/**
 * Provides ${classToResource(activityName)?replace('_', ' ')} activity dependencies.
 */
@Module
abstract class ${Name}ActivityModule {

    @Binds
    @PerActivity
    internal abstract fun activity(activity: ${activityName}): AppCompatActivity

    @Binds
    @PerActivity
    internal abstract fun providerFragmentHelper(activity: ${activityName}): IFragmentProvider<BaseFragment>
}
