package nam.tran.data.network

import nam.tran.data.entities.core.CodeError
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ExeptionInterceptor constructor(private val iNetworkMonitor: INetworkMonitor) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var message = "Network not available"
        return if (iNetworkMonitor.isConnected()) {
            val request = chain.request()
            val response = chain.proceed(request)

            if (response.code() == 401) {
                message = "User or Password incorrect "
                throw NetWorkException(message, CodeError.AUTHEN.code)
            }
            response
        } else {
            throw NetWorkException(message)
        }
    }
}