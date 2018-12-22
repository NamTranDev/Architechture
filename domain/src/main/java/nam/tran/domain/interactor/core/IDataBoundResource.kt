package nam.tran.domain.interactor.core

import retrofit2.Call

interface IDataBoundResource<RequestType> {

    fun statusLoading(): Int

    fun createCall(): Call<RequestType>
}