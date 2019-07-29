package nam.tran.data.network

import io.reactivex.Single
import nam.tran.data.entities.EventEntityData
import nam.tran.data.entities.UserEntityData
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface IApi{

    @GET("user")
    fun login(@Header("Authorization") basicToken: String): Single<UserEntityData>

    @GET("users/{user}/received_events")
    fun getEvent(@Path("user") user : String,@Query("page") page : Int,@Query("per_page") per_page : Int) : Single<List<EventEntityData>>
}
