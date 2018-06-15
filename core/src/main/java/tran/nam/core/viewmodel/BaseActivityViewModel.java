package tran.nam.core.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import nam.tran.domain.entity.state.Resource;

@SuppressWarnings("unused")
public abstract class BaseActivityViewModel<V extends IViewModel> extends AndroidViewModel implements LifecycleObserver {

    @Nullable
    private volatile WeakReference<V> mViewWeakReference;

    private CompositeDisposable compositeDisposables;

    public BaseActivityViewModel(@NonNull Application application) {
        super(application);
    }

    @Nullable
    protected V view() {
        final WeakReference<V> viewWeakReference = this.mViewWeakReference;
        if (viewWeakReference == null)
            return null;
        return viewWeakReference.get();
    }

    public void onCreated(@NonNull V view) {
        mViewWeakReference = new WeakReference<>(view);
        if (compositeDisposables == null)
            compositeDisposables = new CompositeDisposable();
        view.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void create() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME) public void resume() {}

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE) public void pause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop() {
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    public void onSaveInstanceState(Bundle outState) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void cleanup() {
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

    public void addDisposable(Disposable disposable) {
        compositeDisposables.add(disposable);
    }
}
