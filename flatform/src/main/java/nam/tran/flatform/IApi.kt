package nam.tran.flatform

import android.arch.lifecycle.LiveData

import nam.tran.flatform.core.ApiResponse
import nam.tran.flatform.model.response.session.SoccerSeason
import nam.tran.flatform.model.response.team.ListTeamResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface IApi {
    @get:GET("/v1/soccerseasons")
    val listSeason: LiveData<ApiResponse<List<SoccerSeason>>>

    @GET("v1/soccerseasons/{id}/teams")
    fun getListTeam(@Path("id") id: Int): LiveData<ApiResponse<ListTeamResponse>>
}
