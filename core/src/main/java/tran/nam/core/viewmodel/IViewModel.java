package tran.nam.core.viewmodel;

import android.arch.lifecycle.LifecycleOwner;

import nam.tran.domain.entity.state.Loading;
import nam.tran.domain.entity.state.Status;

@SuppressWarnings("unused")
public interface IViewModel extends LifecycleOwner {

    void showDialogLoading();

    void hideDialogLoading();

    void onShowDialogError(String message);
}
