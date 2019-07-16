package nam.tran.data.di.network

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager


class LiveNetworkMonitor constructor(private val context: Context) : INetworkMonitor {

    @SuppressLint("MissingPermission")
    override fun isConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }

}