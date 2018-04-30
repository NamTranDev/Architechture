package nam.tran.architechture.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.support.AndroidSupportInjectionModule;
import nam.tran.architechture.application.view.AppState;
import nam.tran.domain.di.DataModule;

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
}
