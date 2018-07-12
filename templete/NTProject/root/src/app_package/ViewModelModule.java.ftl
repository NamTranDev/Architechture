package ${packageName}.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import tran.nam.core.di.ViewModelFactory;
import tran.nam.core.di.inject.ViewModelKey;

@SuppressWarnings({"unused", "WeakerAccess"})
@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
    
}
