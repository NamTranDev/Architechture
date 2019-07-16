package nam.tran.data.di.local

interface IPreference{
    fun login(isRemember: Boolean)
    fun isRememberLogin() : Boolean
}

