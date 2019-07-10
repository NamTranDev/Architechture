package nam.tran.architechture.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import nam.tran.architechture.view.AppState
import nam.tran.architechture.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : AndroidInjector<AppState> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(appState: AppState): Builder

        fun build(): AppComponent
    }
}
