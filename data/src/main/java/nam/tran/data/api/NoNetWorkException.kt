package nam.tran.data.api

import java.io.IOException

class NoNetWorkException : IOException(){
    override val message: String?
        get() = "Network not available"
}