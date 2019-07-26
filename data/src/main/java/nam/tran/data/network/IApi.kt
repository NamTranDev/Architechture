package nam.tran.data.network

import io.reactivex.Single
import nam.tran.data.entities.UserEntityData
import retrofit2.http.GET
import retrofit2.http.Header

interface IApi{

    @GET("user")
    fun login(@Header("Authorization") basicToken: String): Single<UserEntityData>
}
