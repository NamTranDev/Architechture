package nam.tran.architechture.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import nam.tran.architechture.view.main.activity.season.viewmodel.SoccerSeasonViewModel
import nam.tran.architechture.view.main.activity.team.viewmodel.TeamViewModel
import nam.tran.architechture.view.main.fragment.parent.season.viewmodel.SoccerSeasonChildViewModel
import tran.nam.core.di.ViewModelFactory
import tran.nam.core.di.inject.ViewModelKey

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SoccerSeasonViewModel::class)
    internal abstract fun bindSoccerSeasonViewModel(model: SoccerSeasonViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TeamViewModel::class)
    internal abstract fun bindTeamViewModel(model: TeamViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SoccerSeasonChildViewModel::class)
    internal abstract fun bindSoccerSeasonChildViewModel(model: SoccerSeasonChildViewModel): ViewModel
}
