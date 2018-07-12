package ${packageName}.di.component;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import ${packageName}.view.AppState;
import ${packageName}.di.module.AppModule;

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
