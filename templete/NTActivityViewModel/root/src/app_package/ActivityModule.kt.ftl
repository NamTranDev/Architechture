package ${packageName}.${funtionName}

import androidx.appcompat.app.AppCompatActivity

import dagger.Binds
import dagger.Module
import tran.nam.core.di.inject.PerActivity

/**
 * Provides ${classToResource(activityName)?replace('_', ' ')} activity dependencies.
 */
@Module
abstract class ${Name}ActivityModule {

    @Binds
    @PerActivity
    internal abstract fun activity(activity: ${activityName}): AppCompatActivity
}
