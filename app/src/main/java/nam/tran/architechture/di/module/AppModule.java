package nam.tran.architechture.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import nam.tran.architechture.test.activity.baseActivity.TestActivityBase;
import nam.tran.architechture.test.activity.baseActivity.module.TestActivityBaseModule;
import nam.tran.architechture.test.activity.mvvm.TestActivityMvvm;
import nam.tran.architechture.test.activity.mvvm.module.TestActivityMvvmActivityModule;
import nam.tran.architechture.test.activity.mvvm.viewmodel.TestActivityMvvmViewModel;
import nam.tran.architechture.test.activity.mvvmWithFragment.TestActivityMvvmWithFM;
import nam.tran.architechture.test.activity.mvvmWithFragment.module.TestActivityMvvmWithFmActivityModule;
import nam.tran.architechture.test.activity.withFragment.TestActivityWithFragment;
import nam.tran.architechture.test.activity.withFragment.module.TestActivityWithFragmentModule;
import nam.tran.architechture.view.AppState;
import nam.tran.architechture.view.main.MainActivity;
import nam.tran.architechture.view.main.module.MainActivityModule;
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
    abstract MainActivity splashActivityInjector();

    /**
     * Provides the injector for the {@link MainActivityModule}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerActivity
    @ContributesAndroidInjector(modules = TestActivityBaseModule.class)
    abstract TestActivityBase testActivityBaseActivityInjector();

    /**
     * Provides the injector for the {@link TestActivityWithFragmentModule}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerActivity
    @ContributesAndroidInjector(modules = TestActivityWithFragmentModule.class)
    abstract TestActivityWithFragment testActivityWithFragmentInjector();

    /**
     * Provides the injector for the {@link TestActivityMvvmActivityModule}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerActivity
    @ContributesAndroidInjector(modules = TestActivityMvvmActivityModule.class)
    abstract TestActivityMvvm testActivityMvvmInjector();

    /**
     * Provides the injector for the {@link TestActivityMvvmWithFmActivityModule}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerActivity
    @ContributesAndroidInjector(modules = TestActivityMvvmWithFmActivityModule.class)
    abstract TestActivityMvvmWithFM testActivityMvvmWithFMInjector();
}
