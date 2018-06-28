package nam.tran.architechture.di.module;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import tran.nam.core.di.ViewModelFactory;

@SuppressWarnings({"unused", "WeakerAccess"})
@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
