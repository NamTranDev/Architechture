package nam.tran.architechture.application;

import javax.inject.Inject;
import javax.inject.Singleton;

import tran.nam.core.Navigator;

@SuppressWarnings("WeakerAccess")
@Singleton
public class NavigatorApp extends Navigator{

    @Inject
    NavigatorApp() {
    }
}
