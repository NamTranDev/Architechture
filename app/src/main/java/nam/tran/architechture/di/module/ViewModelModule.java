package nam.tran.architechture.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import nam.tran.architechture.view.main.activity.season.viewmodel.SoccerSeasonViewModel;
import nam.tran.architechture.view.main.activity.team.viewmodel.TeamViewModel;
import nam.tran.architechture.view.main.fragment.parent.season.viewmodel.SoccerSeasonChildViewModel;
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
    abstract ViewModel bindSoccerSeasonViewModel(SoccerSeasonViewModel model);

    @Binds
    @IntoMap
    @ViewModelKey(TeamViewModel.class)
    abstract ViewModel bindTeamViewModel(TeamViewModel model);

    @Binds
    @IntoMap
    @ViewModelKey(SoccerSeasonChildViewModel.class)
    abstract ViewModel bindSoccerSeasonChildViewModel(SoccerSeasonChildViewModel model);
}
