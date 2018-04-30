package nam.tran.flatform.di;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import nam.tran.flatform.local.IPreference;
import nam.tran.flatform.local.Preference;

@SuppressWarnings("unused")
@Module
public abstract class PreferenceModule {

    @Binds
    @Singleton
    abstract IPreference bindPreference(Preference preferenceProvider);
}
