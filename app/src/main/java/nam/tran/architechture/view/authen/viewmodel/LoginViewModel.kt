package nam.tran.architechture.view.authen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import nam.tran.data.entities.core.state.ErrorState
import nam.tran.data.entities.core.state.Loading
import nam.tran.data.entities.core.state.State
import nam.tran.domain.interactor.UserUseCase
import tran.nam.core.viewmodel.BaseViewModel
import javax.inject.Inject

class LoginViewModel @Inject internal constructor(private val userUseCase: UserUseCase)
    : BaseViewModel() {

    private val isLoginValue = MutableLiveData<Boolean>()
    val isLogin: LiveData<Boolean>
        get() = isLoginValue

    fun login(userName: String?, password: String?) {
        val loading = Loading.LOADING_DIALOG

        if (userName == null || userName.isEmpty()) {
            status.set(State.error(ErrorState("Please input user"), loading))
            return
        }
        if (password == null || password.isEmpty()) {
            status.set(State.error(ErrorState("Please input password"), loading))
            return
        }
        status.set(State.loading(loading))
        addDisposable {
            userUseCase.login(userName, password).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe({
                        status.set(State.success(loading))
                        isLoginValue.value = true
                    },{
                        status.set(State.error(ErrorState.getErrorMessage(it), loading))
                    })
        }
    }
}
