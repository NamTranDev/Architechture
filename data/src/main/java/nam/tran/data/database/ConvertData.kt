package nam.tran.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import nam.tran.data.entities.LicenseRepository
import nam.tran.data.entities.OwnerRepository
import java.util.*


class ConvertData {

    var gson = Gson()

    @TypeConverter
    fun stringToLicenseRepository(data: String?): LicenseRepository? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<LicenseRepository>() {

        }.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun licenseRepositoryToString(someObjects: LicenseRepository?): String {
        return gson.toJson(someObjects)
    }

    @TypeConverter
    fun stringToOwnerRepository(data: String?): OwnerRepository? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<OwnerRepository>() {

        }.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun ownerRepositoryToString(someObjects: OwnerRepository?): String {
        return gson.toJson(someObjects)
    }
}