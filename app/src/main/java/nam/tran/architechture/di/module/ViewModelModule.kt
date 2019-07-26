package nam.tran.architechture.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import nam.tran.architechture.view.authen.viewmodel.LoginViewModel
import nam.tran.architechture.view.event.viewmodel.EventsViewModel
import nam.tran.architechture.view.repository.viewmodel.RepositoriesViewModel
import nam.tran.architechture.view.user.viewmodel.UserViewModel
import tran.nam.core.di.ViewModelFactory
import tran.nam.core.di.inject.ViewModelKey

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun bindLoginViewModel(model: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EventsViewModel::class)
    internal abstract fun bindEventsViewModel(model: EventsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RepositoriesViewModel::class)
    internal abstract fun bindRepositoriesViewModel(model: RepositoriesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    internal abstract fun bindUserViewModel(model: UserViewModel): ViewModel
}
