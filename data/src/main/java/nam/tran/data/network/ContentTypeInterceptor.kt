package nam.tran.data.network

import nam.tran.data.di.NetModule
import nam.tran.data.local.IPreference
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.HashMap

class ContentTypeInterceptor constructor(private val iPreference: IPreference) : Interceptor {

    companion object {
        const val KEY_CONTENT_TYPE = "Content-Type"
        const val VALUE_CONTENT_TYPE = "application/json"
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()

        val headers = HashMap<String, String>()
        headers[KEY_CONTENT_TYPE] = VALUE_CONTENT_TYPE
        for ((key, value) in headers) {
            builder.addHeader(key, value)
        }
        return chain.proceed(builder.build())
    }
}
