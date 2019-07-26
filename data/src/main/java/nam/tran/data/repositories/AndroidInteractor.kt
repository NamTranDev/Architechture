package nam.tran.data.repositories

import android.util.Base64
import nam.tran.data.Logger
import nam.tran.domain.repositories.IAndroidInteractor
import javax.inject.Inject

open class AndroidInteractor @Inject internal constructor(): IAndroidInteractor {

    override fun getBasicAuth(username: String, password: String): String {
        val credentials = "$username:$password"
        val credentialEncode = Base64.encodeToString(credentials.toByteArray(), 2)
        Logger.debug(credentialEncode)
        return "Basic $credentialEncode"
    }

}