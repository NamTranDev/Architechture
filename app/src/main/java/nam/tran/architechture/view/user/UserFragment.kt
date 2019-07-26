package nam.tran.architechture.view.user

import android.os.Bundle
import android.view.View
import nam.tran.architechture.view.user.viewmodel.UserViewModel

import nam.tran.architechture.R
import nam.tran.architechture.databinding.FragmentUserBinding

import tran.nam.core.view.mvvm.BaseFragmentVM

class UserFragment : BaseFragmentVM<FragmentUserBinding, UserViewModel>() {

    override fun layoutId(): Int {
        return R.layout.fragment_user
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewDataBinding.viewModel = mViewModel
    }
}
