package nam.tran.domain.di

import javax.inject.Singleton

import dagger.Binds
import dagger.Module
import nam.tran.domain.IRepository
import nam.tran.domain.Repository
import nam.tran.domain.executor.AppSchedulerProvider
import nam.tran.domain.executor.SchedulerProvider
import nam.tran.domain.interactor.TeamUseCase
import nam.tran.domain.interactor.usecase.ITeamUseCase
import nam.tran.flatform.di.PreferenceModule
import nam.tran.domain.interactor.SoccerSeasonUseCase
import nam.tran.domain.interactor.usecase.ISoccerSeasonUseCase
import nam.tran.flatform.di.DbModule
import nam.tran.flatform.di.NetModule


@Module(includes = arrayOf(NetModule::class, DbModule::class, PreferenceModule::class))
abstract class DataModule {

    @Binds
    @Singleton
    internal abstract fun provideRepository(repository: Repository): IRepository

    @Binds
    @Singleton
    internal abstract fun provideSchedulerProvider(schedulerProvider: AppSchedulerProvider): SchedulerProvider

    @Binds
    @Singleton
    internal abstract fun provideSoccerUseCase(soccerSeasonUseCase: SoccerSeasonUseCase): ISoccerSeasonUseCase

    @Binds
    @Singleton
    internal abstract fun provideTeamUseCase(teamUseCase: TeamUseCase): ITeamUseCase
}
