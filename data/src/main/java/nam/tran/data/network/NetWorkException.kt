package nam.tran.data.network

import nam.tran.data.entities.core.CodeError
import java.io.IOException

class NetWorkException constructor(val messageError: String,
                                   val code: Int = CodeError.NOT_NETWORK.code) : IOException() {
    override val message: String?
        get() = messageError
}