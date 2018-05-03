package tran.nam.util;

import android.util.SparseArray;

public interface Constant {

    String API_URL = "https://api.football-data.org";
    String EMPTY = "";

    /*Roboto FONT*/
    int FONT_STYLE_REGULAR = 0;
    int FONT_STYLE_MEDIUM = 1;
    int FONT_STYLE_LIGHT = 2;
    int FONT_STYLE_THIN = 3;

    SparseArray<String> FONT_STYLES = new SparseArray<String>() {
        {
            append(FONT_STYLE_REGULAR, "Roboto-Regular.ttf");
            append(FONT_STYLE_MEDIUM, "Roboto-Medium.ttf");
            append(FONT_STYLE_LIGHT, "Roboto-Light.ttf");
            append(FONT_STYLE_THIN, "Roboto-Thin.ttf");
        }
    };
    // No breaking space letter
    String NON_BREAKING_SPACE = "\u00A0";

    @SuppressWarnings("unused")
    interface REQUEST_CODE{

    }

    interface KEY_INTENT{

    }

    interface KEY_INTENT_RESULT{

    }

    interface KEY_DIALOG{

    }
}
