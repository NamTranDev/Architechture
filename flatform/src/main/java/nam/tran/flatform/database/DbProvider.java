package nam.tran.flatform.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import nam.tran.flatform.model.response.session.SoccerSeason;
import nam.tran.flatform.model.response.team.Team;

@Database(entities = {SoccerSeason.class, Team.class}, version = 1, exportSchema = false)
public abstract class DbProvider extends RoomDatabase {
    public abstract SoccerSeasonDao soccerSeasonDao();

    public abstract TeamDao teamDao();
}
