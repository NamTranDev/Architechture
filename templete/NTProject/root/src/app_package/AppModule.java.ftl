package ${packageName}.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import ${packageName}.view.AppState;
import nam.tran.domain.di.DataModule;
import tran.nam.core.di.inject.PerActivity;

import ${packageName}.view.splash.SplashActivity;
import ${packageName}.view.splash.SplashActivityModule;
import ${packageName}.view.${funtionName}.${activityName};
import ${packageName}.view.${funtionName}.${Name}ActivityModule;

/**
 * Provides application-wide dependencies.
 */
@SuppressWarnings("unused")
@Module(includes = {
        AndroidSupportInjectionModule.class,
        ViewModelModule.class,
        DataModule.class
})
public abstract class AppModule {

    @Binds
    @Singleton
    /*
     * Singleton annotation isn't necessary since Application instance is unique but is here for
     * convention. In general, providing Activity, Fragment, BroadcastReceiver, etc does not require
     * them to be scoped since they are the components being injected and their instance is unique.
     *
     * However, having a scope annotation makes the module easier to read. We wouldn't have to look
     * at what is being provided in order to understand its scope.
     */
    abstract Application application(AppState app);

    /**
    * Provides the injector for the {@link SplashActivityModule}, which has access to the dependencies
    * provided by this application instance (singleton scoped objects).
    */
    @PerActivity
    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity SplashActivityInjector();

    /**
    * Provides the injector for the {@link ${Name}ActivityModule}, which has access to the dependencies
    * provided by this application instance (singleton scoped objects).
    */
    @PerActivity
    @ContributesAndroidInjector(modules = ${Name}ActivityModule.class)
    abstract ${activityName} ${activityName}Injector();
}