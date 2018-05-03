package nam.tran.domain.interactor.core;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subscribers.DisposableSubscriber;
import nam.tran.domain.IRepository;
import nam.tran.domain.executor.SchedulerProvider;
import tran.nam.util.Checker;

/**
 * Abstract class for a Use Case Field(Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 * <p>
 * By convention each UseCase implementation will return the result using a {@link DisposableObserver}
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
public abstract class UseCaseField<T, Params> {

    private SchedulerProvider schedulerProvider;
    protected IRepository iRepository;

    public UseCaseField(IRepository iRepository, SchedulerProvider schedulerProvider) {
        this.iRepository = iRepository;
        this.schedulerProvider = schedulerProvider;
    }

    /**
     * Builds an {@link Flowable} which will be used when executing the current {@link UseCase}.
     */
    protected abstract Flowable<T> buildUseCaseFlowable(Params params);

    /**
     * Builds an {@link Flowable} which will be used when executing the current {@link UseCase}.
     */
    protected abstract Observable<T> buildUseCaseObserve(Params params);

    /**
     * Builds an {@link Completable} which will be used when executing the current {@link UseCase}.
     */
    protected abstract Completable buildUseCaseCompletable(Params params);

    /**
     * Executes the current use case.
     *
     * @param subscriber {@link DisposableSubscriber} which will be listening to the observable build
     *                   by {@link #buildUseCaseFlowable(Params)} ()} method.
     * @param params     Parameters (Optional) used to build/execute this use case.
     */
    public Disposable execute(DisposableSubscriber<T> subscriber, Params params) {
        Checker.checkNotNull(subscriber);
        if (subscriber.isDisposed())
            subscriber.dispose();
        final Flowable<T> flowable = this.buildUseCaseFlowable(params)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui());
        return flowable.subscribeWith(subscriber);
    }

    /**
     * Executes the current use case.
     *
     * @param observer {@link DisposableObserver} which will be listening to the observable build
     *                 by {@link #buildUseCaseObserve(Params)} ()} method.
     * @param params   Parameters (Optional) used to build/execute this use case.
     */
    public Disposable execute(DisposableObserver<T> observer, Params params) {
        Checker.checkNotNull(observer);
        if (observer.isDisposed())
            observer.dispose();
        final Observable<T> observable = this.buildUseCaseObserve(params)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui());
        return observable.subscribeWith(observer);
    }

    /**
     * Executes the current use case.
     *
     * @param subscriber {@link DisposableSubscriber} which will be listening to the observable build
     *                   by {@link #buildUseCaseFlowable(Params)} ()} method.
     * @param params     Parameters (Optional) used to build/execute this use case.
     */
    public Disposable execute(DisposableCompletableObserver subscriber, Params params) {
        Checker.checkNotNull(subscriber);
        final Completable completable = this.buildUseCaseCompletable(params)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui());
        return completable.subscribeWith(subscriber);
    }
}
