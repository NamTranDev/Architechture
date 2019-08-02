package nam.tran.data.base

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import nam.tran.data.Logger
import nam.tran.data.entities.core.state.State

@SuppressLint("CheckResult")
abstract class BasePageKeyedDataSource<T> : PageKeyedDataSource<Int, T>() {

    val state = MutableLiveData<State>()

    private var compositeDisposable = CompositeDisposable()

    abstract fun getData(isLoadMore: Boolean, page: Int, countItem: Int, callback: (List<T>, Int, Int?) -> Unit): Disposable

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, T>) {
        Logger.debug("loadInitial")

        addDisposable(getData(false, 0, params.requestedLoadSize) { datas, page, count ->
            run {
                callback.onResult(datas, page, count)
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
        Logger.debug("loadAfter")
        addDisposable(getData(true, params.key, params.requestedLoadSize) { datas, page, count ->
            run {
                callback.onResult(datas, page)
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {

    }

    override fun invalidate() {
        super.invalidate()
        compositeDisposable.dispose()
    }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}