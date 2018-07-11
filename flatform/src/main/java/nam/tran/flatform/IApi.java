package nam.tran.flatform;

import android.arch.lifecycle.LiveData;

import java.util.List;

import nam.tran.flatform.core.ApiResponse;
import nam.tran.flatform.model.response.session.SoccerSeason;
import nam.tran.flatform.model.response.team.ListTeamResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IApi {
    @GET("/v1/soccerseasons")
    LiveData<ApiResponse<List<SoccerSeason>>> getListSeason();

    @GET("v1/soccerseasons/{id}/teams")
    LiveData<ApiResponse<ListTeamResponse>> getListTeam(@Path("id") int id);
}
