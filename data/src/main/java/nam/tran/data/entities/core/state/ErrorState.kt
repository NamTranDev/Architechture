package nam.tran.data.entities.core.state

import nam.tran.data.Logger
import nam.tran.data.entities.core.CodeError
import nam.tran.data.network.NetWorkException

data class ErrorState(var message: String? = null, var code: Int? = 0){

    companion object {
        fun getErrorMessage(t: Throwable): ErrorState {
            Logger.debug(t)
            val errorHandler = ErrorState()
            if (t is NetWorkException) {
                errorHandler.message = t.message
                errorHandler.code = t.code
            }else{
                errorHandler.code = CodeError.UN_KNOWN_ERROR.code
            }
            return errorHandler
        }
    }
}