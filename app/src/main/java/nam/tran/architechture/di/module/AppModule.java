package nam.tran.architechture.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import nam.tran.architechture.view.AppState;
import nam.tran.architechture.view.main.MainActivity;
import nam.tran.architechture.view.main.MainActivityModule;
import nam.tran.architechture.view.main.activity.TestTempleteActivity;
import nam.tran.architechture.view.main.activity.TestTempleteActivityModule;
import nam.tran.architechture.view.main.activity.team.TeamActivity;
import nam.tran.architechture.view.main.activity.team.TeamActivityModule;
import nam.tran.architechture.view.main.fragment.TestFragmentTempleteActivity;
import nam.tran.architechture.view.main.fragment.TestFragmentTempleteActivityModule;
import nam.tran.domain.di.DataModule;
import tran.nam.core.di.inject.PerActivity;

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
    * Provides the injector for the {@link MainActivityModule}, which has access to the dependencies
    * provided by this application instance (singleton scoped objects).
    */
    @PerActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity MainActivityInjector();

    /**
    * Provides the injector for the {@link TestTempleteActivityModule}, which has access to the dependencies
    * provided by this application instance (singleton scoped objects).
    */
    @PerActivity
    @ContributesAndroidInjector(modules = TestTempleteActivityModule.class)
    abstract TestTempleteActivity injectorTestTempleteActivity();

    /**
    * Provides the injector for the {@link TeamActivityModule}, which has access to the dependencies
    * provided by this application instance (singleton scoped objects).
    */
    @PerActivity
    @ContributesAndroidInjector(modules = TeamActivityModule.class)
    abstract TeamActivity injectorTeamActivity();

    /**
    * Provides the injector for the {@link TestFragmentTempleteActivityModule}, which has access to the dependencies
    * provided by this application instance (singleton scoped objects).
    */
    @PerActivity
    @ContributesAndroidInjector(modules = TestFragmentTempleteActivityModule.class)
    abstract TestFragmentTempleteActivity injectorTestFragmentTempleteActivity();
}
