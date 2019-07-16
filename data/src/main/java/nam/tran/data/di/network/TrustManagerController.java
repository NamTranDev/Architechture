package nam.tran.data.di.network;

import android.annotation.SuppressLint;

import javax.inject.Inject;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class TrustManagerController {

    @Inject
    TrustManagerController() {}

    @SuppressLint("TrustAllX509TrustManager")
    public TrustManager[] getTrustManager() {
        return new TrustManager[]{
                new X509TrustManager() {

                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new java.security.cert.X509Certificate[]{};
                    }
                }
        };
    }
}
