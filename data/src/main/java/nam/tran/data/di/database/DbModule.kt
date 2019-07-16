package nam.tran.data.di.database

import dagger.Module
import nam.tran.data.Logger
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

@Module
class DbModule {

    init {
        System.loadLibrary("keys")
    }

    companion object {
        private const val DB_NAME = "toiec.db"
    }

    external fun getDBKEY(): String

//    @Singleton
//    @Provides
//    fun provideDb(app: Application): DbProvider {
//        val dbFile = app.getDatabasePath(DB_NAME)
//        if (!dbFile.exists()) {
//            dbFile.parentFile.mkdirs()
//            copyAttachedDatabase(app.assets.open(DB_NAME), FileOutputStream(dbFile))
//        }
//        return Room
//                .databaseBuilder(app, DbProvider::class.java, DB_NAME)
//                .openHelperFactory(SafeHelperFactory.fromUser(SpannableStringBuilder(getDBKEY()),SafeHelperFactory.POST_KEY_SQL_V3))
//                .build()
//    }

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
