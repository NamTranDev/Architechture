package nam.tran.architechture.di.component;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import nam.tran.architechture.view.AppState;
import nam.tran.architechture.di.module.AppModule;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent extends AndroidInjector<AppState> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(AppState appState);

        AppComponent build();
    }
}
