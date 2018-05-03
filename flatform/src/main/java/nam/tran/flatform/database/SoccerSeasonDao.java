package nam.tran.flatform.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import nam.tran.flatform.model.response.session.SoccerSeason;

/**
 * Interface for database access for SoccerSeason related operations.
 */
@Dao
public interface SoccerSeasonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<SoccerSeason> season);

    @Query("SELECT * FROM soccerseason")
    LiveData<List<SoccerSeason>> fetchSoccerSeason();
}
