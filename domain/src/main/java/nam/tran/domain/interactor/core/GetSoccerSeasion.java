package nam.tran.domain.interactor.core;

import android.arch.lifecycle.MutableLiveData;

import io.reactivex.subscribers.DisposableSubscriber;
import nam.tran.domain.entity.state.Loading;
import nam.tran.domain.entity.state.Resource;

public abstract class GetSoccerSeasion<T> extends DisposableSubscriber<T> {

    private MutableLiveData<Resource<T>> results;
    private @Loading
    int loading;

    public GetSoccerSeasion(MutableLiveData<Resource<T>> results, int loading) {
        this.results = results;
        this.loading = loading;
    }

    @Override
    protected void onStart() {
        super.onStart();
        results.setValue(Resource.loading(null, loading));
    }

    @Override
    public void onError(Throwable t) {
        results.setValue(Resource.error(t.getMessage(), null, loading));
    }

    @Override
    public void onComplete() {

    }
}