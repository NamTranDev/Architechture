package nam.tran.architechture.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import nam.tran.architechture.test.activity.mvvm.viewmodel.TestActivityMvvmViewModel;
import nam.tran.architechture.test.activity.mvvmWithFragment.viewmodel.TestActivityMvvmWithFmViewModel;
import nam.tran.architechture.view.season.viewmodel.SoccerSeasonViewModel;
import tran.nam.core.di.ViewModelFactory;
import tran.nam.core.di.inject.ViewModelKey;

@SuppressWarnings({"unused", "WeakerAccess"})
@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(SoccerSeasonViewModel.class)
    abstract ViewModel bindFragmentSoccerSeasonViewModel(SoccerSeasonViewModel model);

    @Binds
    @IntoMap
    @ViewModelKey(TestActivityMvvmViewModel.class)
    abstract ViewModel bindTestActivityMvvmViewModel(TestActivityMvvmViewModel model);

    @Binds
    @IntoMap
    @ViewModelKey(TestActivityMvvmWithFmViewModel.class)
    abstract ViewModel bindTestActivityMvvmWithFmViewModel(TestActivityMvvmWithFmViewModel model);
}
