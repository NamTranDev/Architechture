package nam.tran.architechture.view.user.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import nam.tran.data.entities.core.state.ErrorState
import nam.tran.data.entities.core.state.Loading
import nam.tran.data.entities.core.state.State
import nam.tran.domain.entities.UserEntity
import nam.tran.domain.interactor.UserUseCase
import tran.nam.core.viewmodel.BaseViewModel
import javax.inject.Inject

class UserViewModel @Inject internal constructor(private val iUserUseCase: UserUseCase)
    : BaseViewModel() {

    val mUserInfo = ObservableField<UserEntity>()

    init {
        loadInfo()
    }

    fun loadInfo(){
        addDisposable { iUserUseCase.getUser().subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    status.set(State.loading())
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    status.set(State.success())
                    mUserInfo.set(it)
                },{
                    status.set(State.error(ErrorState.getErrorMessage(it)))
                })}
    }
}
