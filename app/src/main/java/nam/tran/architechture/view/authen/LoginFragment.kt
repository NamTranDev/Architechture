package nam.tran.architechture.view.authen

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_login.*
import nam.tran.architechture.R
import nam.tran.architechture.databinding.FragmentLoginBinding
import nam.tran.architechture.view.authen.viewmodel.LoginViewModel
import nam.tran.data.Logger
import tran.nam.core.view.mvvm.BaseFragmentVM

class LoginFragment : BaseFragmentVM<FragmentLoginBinding, LoginViewModel>() {

    override fun layoutId(): Int {
        return R.layout.fragment_login
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewDataBinding.viewModel = mViewModel

        edtPassword.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                mViewModel.login(edtUserName.text.toString(),edtPassword.text.toString())
                true
            } else false
        }

        mViewModel.isLogin.observe(viewLifecycleOwner, Observer {
            if (it)
                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                        .navigate(R.id.action_loginFragment_to_homeFragment)
        })
    }

}
