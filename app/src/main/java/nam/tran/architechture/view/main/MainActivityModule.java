package nam.tran.architechture.view.main;

import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import tran.nam.core.di.inject.PerActivity;

/**
 * Provides main activity dependencies.
 */
@Module
public abstract class MainActivityModule {

    @Binds
    @PerActivity
    abstract AppCompatActivity activity(MainActivity activity);
}
