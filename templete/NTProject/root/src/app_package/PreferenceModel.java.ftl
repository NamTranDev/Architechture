package ${packageName}.model;

import android.databinding.BaseObservable;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PreferenceModel extends BaseObservable{

    @Inject
    PreferenceModel() {
    }
}
