package nam.tran.flatform.local;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
@Singleton
public class Preference implements IPreference {

    /**
     * normal configurations
     */
    private static final String SHARED_REFERENCE_NAME = "Alarm Timer Config";

    private SharedPreferences mPref;
    private Application mApp;

    @Inject
    Preference(Application application) {
        this.mApp = application;
        mPref = application.getSharedPreferences(SHARED_REFERENCE_NAME, Context.MODE_PRIVATE);
    }
}
