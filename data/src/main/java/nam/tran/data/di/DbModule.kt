package nam.tran.data.di

import android.app.Application
import android.text.SpannableStringBuilder
import androidx.room.Room
import dagger.Module
import dagger.Provides
import nam.tran.data.Logger
import nam.tran.data.database.DbProvider
import nam.tran.data.database.core.SafeHelperFactory
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import javax.inject.Singleton

@Module
class DbModule {

    init {
        System.loadLibrary("keys")
    }

    companion object {
        private const val DB_NAME = "github.db"
    }

    external fun getDBKEY(): String

    @Provides
    fun provideDb(app: Application): DbProvider {
//        val dbFile = app.getDatabasePath(DB_NAME)
//        if (!dbFile.exists()) {
//            dbFile.parentFile.mkdirs()
//            copyAttachedDatabase(app.assets.open(DB_NAME), FileOutputStream(dbFile))
//        }
        return Room
                .databaseBuilder(app, DbProvider::class.java, DB_NAME)
                .openHelperFactory(SafeHelperFactory.fromUser(SpannableStringBuilder(getDBKEY()),SafeHelperFactory.POST_KEY_SQL_V3))
                .build()
    }

    fun copyAttachedDatabase(inputStream: InputStream, output: FileOutputStream): Boolean {
        // Try to copy database file
        try {
            val buffer = ByteArray(8192)
            var length: Int

            while (inputStream.read(buffer, 0, 8192).let { length = it; length > 0 }) {
                output.write(buffer, 0, length)
            }

            output.flush()
            output.close()
            inputStream.close()
            return true
        } catch (e: IOException) {
            Logger.debug("Failed to open file")
        }
        return false
    }
}
