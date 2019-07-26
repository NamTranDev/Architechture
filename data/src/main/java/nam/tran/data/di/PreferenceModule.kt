package nam.tran.data.di

import dagger.Binds
import dagger.Module
import nam.tran.data.local.IPreference
import nam.tran.data.local.Preference
import javax.inject.Singleton

@Module
abstract class PreferenceModule {

    @Binds
    abstract fun providePreference(preferenceProvider: Preference): IPreference
}
