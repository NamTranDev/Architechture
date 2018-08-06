package nam.tran.flatform.di

import android.app.Application
import android.arch.persistence.room.Room

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import nam.tran.flatform.database.DbProvider

@Module
class DbModule {

    @Singleton
    @Provides
    fun provideDb(app: Application): DbProvider {
        return Room
                .databaseBuilder(app, DbProvider::class.java, "architechture.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}
