package tran.nam.core.viewmodel

import android.os.Bundle
import androidx.annotation.MainThread
import androidx.lifecycle.*
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import nam.tran.data.Logger
import nam.tran.data.model.core.state.State
import tran.nam.extention.setValueIfNew
import java.lang.ref.WeakReference

open class BaseViewModel : ViewModel(), LifecycleObserver {

    @Volatile
    var mViewLoadingWeakReference: WeakReference<IViewLifecycle>? = null

    private val mCompositeDisposable = CompositeDisposable()
    protected val arguments = BehaviorSubject.create<Bundle>()

    // view state
    val status: MutableLiveData<State> = MutableLiveData()

    fun <T> bindTolifecycle(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    protected inline fun <reified V : IViewLifecycle> view(): V? {
        if (mViewLoadingWeakReference == null || mViewLoadingWeakReference?.get() == null)
            return null
        return V::class.java.cast(mViewLoadingWeakReference?.get())
    }

    fun setArgument(bundle: Bundle?) {
        arguments.onNext(bundle ?: Bundle())
    }

    open fun onInitialized() {}

    fun onAttach(viewLoading: IViewLifecycle) {
        Logger.w("BaseViewModel : onAttach()")
        mViewLoadingWeakReference = WeakReference(viewLoading)
        viewLoading.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreated() {
        Logger.w("BaseViewModel : onCreated()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onStart() {
        Logger.w("BaseViewModel : onStart()")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun onResume() {
        Logger.w("BaseViewModel : onResume()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    open fun onPause() {
        Logger.w("BaseViewModel : onPause()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop() {
        Logger.w("BaseViewModel : onStop()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    internal fun onDestroy() {
        Logger.w("BaseViewModel : onDestroy()")
        val viewWeakReference = this.mViewLoadingWeakReference
        if (viewWeakReference != null) {
            val view = viewWeakReference.get()
            view?.lifecycle?.removeObserver(this)
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun onSaveState(state: Bundle) {}

    @Suppress("UNUSED_PARAMETER")
    fun onRestoreState(state: Bundle?) {}

    /**
     * Get current state, [initState] will be returned if current state is null
     */
    protected fun state() = status.value

    /**
     * set new view state and post it through [state] live data
     *
     * @param stateFunc provide new state by applying current state
     */
    @MainThread
    protected fun setState(state: State) {
        status.setValueIfNew(state)
    }

    /**
     * Add an Rx's disposable into [mCompositeDisposable]. All disposables will be disposed when the ViewModel is
     * being cleared, see [onCleared]
     */
    protected fun addDisposable(disposable: () -> Disposable) {
        mCompositeDisposable.add(disposable.invoke())
    }

    override fun onCleared() {
        mCompositeDisposable.dispose()
        super.onCleared()
    }
}
