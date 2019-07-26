package nam.tran.data.di

import dagger.Binds
import dagger.Module
import nam.tran.data.repositories.AndroidInteractor
import nam.tran.data.repositories.UserRepository
import nam.tran.domain.repositories.IAndroidInteractor
import nam.tran.domain.repositories.IUserRepository

@Module(includes = [NetModule::class, DbModule::class, PreferenceModule::class])
abstract class DataModule {

    @Binds
    abstract fun provideAndroidInteractor(androidInteractor: AndroidInteractor): IAndroidInteractor

    @Binds
    abstract fun provideUserRepository(userRepository: UserRepository): IUserRepository
}
