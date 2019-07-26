package nam.tran.architechture.view

import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import nam.tran.architechture.view.authen.LoginFragment
import nam.tran.architechture.view.authen.LoginFragmentModule
import nam.tran.architechture.view.home.HomeFragment
import nam.tran.architechture.view.home.HomeFragmentModule
import nam.tran.architechture.view.splash.SplashFragment
import nam.tran.architechture.view.splash.SplashFragmentModule
import tran.nam.core.di.inject.PerActivity
import tran.nam.core.di.inject.PerFragment

/**
 * Provides main activity dependencies.
 */
@Module
abstract class MainActivityModule {

    @Binds
    @PerActivity
    internal abstract fun activity(activity: MainActivity): AppCompatActivity

    /**
     * Provides the injector for the [SplashFragmentModule], which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = [SplashFragmentModule::class])
    internal abstract fun injectorSplashFragment(): SplashFragment

    /**
     * Provides the injector for the [LoginFragmentModule], which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = [LoginFragmentModule::class])
    internal abstract fun injectorLoginFragment(): LoginFragment

    /**
     * Provides the injector for the [HomeFragmentModule], which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    internal abstract fun injectorHomeFragment(): HomeFragment
}