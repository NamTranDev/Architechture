package nam.tran.flatform.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import nam.tran.flatform.model.response.team.Team;

/**
 * Interface for database access for Team related operations.
 */
@Dao
public interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Team> teams);

    @Query("SELECT * FROM team WHERE idSeason = :idSeason")
    LiveData<List<Team>> fetchTeams(int idSeason);
}
