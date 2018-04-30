package tran.nam.core.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

@SuppressWarnings("unused")
public class BaseFragmentViewModel<V extends IViewModel> extends AndroidViewModel implements LifecycleObserver {

    @Nullable
    private volatile WeakReference<V> mViewWeakReference;

    public BaseFragmentViewModel(@NonNull Application application) {
        super(application);
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

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreated() {
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
}
