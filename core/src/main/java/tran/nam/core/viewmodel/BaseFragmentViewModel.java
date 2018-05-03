package tran.nam.core.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;
import java.util.List;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import nam.tran.domain.entity.state.Resource;

public class BaseFragmentViewModel<V extends IViewModel,T> extends AndroidViewModel implements LifecycleObserver {

    @Nullable
    private volatile WeakReference<V> mViewWeakReference;

    private CompositeDisposable compositeDisposables;

    protected MutableLiveData<Resource<T>> results;

    public BaseFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public Resource<T> getResource(){
        if (results == null)
            return null;
        return results.getValue();
    }

    @Nullable
    protected V view() {
        final WeakReference<V> viewWeakReference = this.mViewWeakReference;
        if (viewWeakReference == null)
            return null;
        return viewWeakReference.get();
    }

    public void onAttach(@NonNull V view) {
        mViewWeakReference = new WeakReference<>(view);
        view.getLifecycle().addObserver(this);
    }

    public void onInitialized() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE) public void onCreated() {
        if (compositeDisposables == null)
            compositeDisposables = new CompositeDisposable();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        final WeakReference<V> viewWeakReference = this.mViewWeakReference;
        if (viewWeakReference != null) {
            V view = viewWeakReference.get();
            if (view != null) {
                view.getLifecycle().removeObserver(this);
            }
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposables != null)
            compositeDisposables.dispose();
    }

    protected void addDisposable(Disposable disposable) {
        compositeDisposables.add(disposable);
    }
}
