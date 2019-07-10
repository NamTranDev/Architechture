package nam.tran.data.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

//    @Singleton
//    @Provides
//    fun provideDb(app: Application): DbProvider {
//        return Room
//            .databaseBuilder(app, DbProvider::class.java, "application.db")
//            .fallbackToDestructiveMigration()
//            .build()
//    }
}
