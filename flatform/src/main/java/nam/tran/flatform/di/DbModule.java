package nam.tran.flatform.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
//import nam.tran.flatform.database.DbProvider;
//import tran.nam.util.Constant;

@Module
public class DbModule {

//    @Singleton
//    @Provides
//    DbProvider provideDb(Application app) {
//        return Room.databaseBuilder(app, DbProvider.class, Constant.DB_NAME).fallbackToDestructiveMigration()
//                .build();
//    }
}
