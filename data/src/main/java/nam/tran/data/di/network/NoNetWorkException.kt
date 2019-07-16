package nam.tran.data.di.network

import java.io.IOException

class NoNetWorkException : IOException(){
    override val message: String?
        get() = "Network not available"
}