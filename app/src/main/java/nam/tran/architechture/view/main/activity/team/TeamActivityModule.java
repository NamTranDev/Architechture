package nam.tran.architechture.view.main.activity.team;

import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import tran.nam.core.di.inject.PerActivity;
import tran.nam.core.view.BaseActivity;

/**
 * Provides team activity dependencies.
 */
@Module
public abstract class TeamActivityModule {

    @Binds
    @PerActivity
    abstract AppCompatActivity activity(TeamActivity activity);
}
