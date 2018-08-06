package nam.tran.domain

import android.arch.lifecycle.LiveData

import nam.tran.domain.entity.SoccerSeasonEntity
import nam.tran.domain.entity.TeamEntity
import nam.tran.domain.entity.state.Resource

interface IRepository {

    val listSeason: LiveData<Resource<List<SoccerSeasonEntity>>>

    fun getListTeam(idSeason: Int, type: Int): LiveData<Resource<List<TeamEntity>>>
}
