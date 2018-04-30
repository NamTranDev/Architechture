package tran.nam.core.viewmodel;

import android.arch.lifecycle.LifecycleOwner;

import nam.tran.domain.entity.state.Status;

@SuppressWarnings("unused")
public interface IViewModel extends LifecycleOwner {

    void showDialogLoading();

    void hideDialogLoading();

    void onShowMessageError(@Status int status, Throwable cause);

    void onShowMessageError(int message);
}
