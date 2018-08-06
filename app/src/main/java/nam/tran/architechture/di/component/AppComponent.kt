package nam.tran.architechture.di.component

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import nam.tran.architechture.view.AppState
import nam.tran.architechture.di.module.AppModule

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent : AndroidInjector<AppState> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(appState: AppState): AppComponent.Builder

        fun build(): AppComponent
    }
}
