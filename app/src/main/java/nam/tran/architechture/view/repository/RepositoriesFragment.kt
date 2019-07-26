package nam.tran.architechture.view.repository

import nam.tran.architechture.R
import nam.tran.architechture.databinding.FragmentRepositoriesBinding
import nam.tran.architechture.view.repository.viewmodel.RepositoriesViewModel
import tran.nam.core.view.mvvm.BaseFragmentVM

class RepositoriesFragment : BaseFragmentVM<FragmentRepositoriesBinding, RepositoriesViewModel>() {

    override fun layoutId(): Int {
        return R.layout.fragment_repositories
    }
}
