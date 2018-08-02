package nam.tran.architechture.view.main.fragment;

import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import nam.tran.architechture.view.main.fragment.parent.ParentFragment;
import nam.tran.architechture.view.main.fragment.parent.ParentFragmentModule;
import tran.nam.core.di.inject.PerActivity;
import tran.nam.core.di.inject.PerFragment;
import tran.nam.core.view.BaseFragment;
import tran.nam.core.view.IFragmentProvider;

/**
 * Provides test fragment templete activity dependencies.
 */
@Module
public abstract class TestFragmentTempleteActivityModule {

    /**
     * Provides the injector for the {@link ParentFragmentModule}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = ParentFragmentModule.class)
    abstract ParentFragment injectorParentFragment();

    @Binds
    @PerActivity
    abstract AppCompatActivity activity(TestFragmentTempleteActivity activity);


    @Binds
    @PerActivity
    abstract IFragmentProvider<BaseFragment> providerFragmentHelper(TestFragmentTempleteActivity activity);
}
