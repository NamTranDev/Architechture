package nam.tran.architechture.view.repository

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import nam.tran.architechture.R
import nam.tran.architechture.databinding.FragmentRepositoriesBinding
import nam.tran.architechture.view.event.EventAdapter
import nam.tran.architechture.view.repository.viewmodel.RepositoriesViewModel
import nam.tran.data.Logger
import tran.nam.core.biding.FragmentDataBindingComponent
import tran.nam.core.view.mvvm.BaseFragmentVM

class RepositoriesFragment : BaseFragmentVM<FragmentRepositoriesBinding, RepositoriesViewModel>() {

    private val dataBindingComponent = FragmentDataBindingComponent(this)

    override fun layoutId(): Int {
        return R.layout.fragment_repositories
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewDataBinding.viewModel = mViewModel

        val adapter = RepositoryAdapter(dataBindingComponent)

        mViewDataBinding.rvRepository.adapter = adapter

        mViewDataBinding.rvRepository.addItemDecoration(
                DividerItemDecoration(
                        context,
                        LinearLayoutManager.VERTICAL
                )
        )

        mViewModel.state.observe(viewLifecycleOwner, Observer {
            mViewModel.status.set(it)
        })

        mViewModel.repoData.observe(viewLifecycleOwner, Observer {
            Logger.debug(it.size)
            adapter.submitList(it)
        })
    }
}
