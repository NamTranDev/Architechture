package nam.tran.data.mapper

import io.reactivex.functions.Consumer

abstract class Mapper<E, T> {

    abstract fun mapFrom(e: E): T

    fun mapFrom(e: E, tConsumer: Consumer<T>?): T {
        val value = mapFrom(e)
        if (tConsumer != null) {
            try {
                tConsumer.accept(value)
            } catch (ignored: Exception) {
            }

        }
        return value
    }

    @JvmOverloads
    fun mapFrom(eList: List<E>?, tConsumer: Consumer<T>? = null): List<T> {
        val list = ArrayList<T>()
        if (eList != null) {
            for (e in eList) {
                list.add(mapFrom(e, tConsumer))
            }
        }
        return list
    }
}
