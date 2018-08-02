package nam.tran.architechture.view.main.activity;

import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import nam.tran.architechture.view.main.activity.season.SoccerSeasonFragment;
import nam.tran.architechture.view.main.activity.season.SoccerSeasonFragmentModule;
import tran.nam.core.di.inject.PerActivity;
import tran.nam.core.di.inject.PerFragment;
import tran.nam.core.view.BaseFragment;
import tran.nam.core.view.IFragmentProvider;

/**
 * Provides test templete activity dependencies.
 */
@Module
public abstract class TestTempleteActivityModule {

    /**
     * Provides the injector for the {@link SoccerSeasonFragmentModule}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = SoccerSeasonFragmentModule.class)
    abstract SoccerSeasonFragment injectorSoccerSeasonFragment();

    @Binds
    @PerActivity
    abstract AppCompatActivity activity(TestTempleteActivity activity);


    @Binds
    @PerActivity
    abstract IFragmentProvider<BaseFragment> providerFragmentHelper(TestTempleteActivity activity);
}
