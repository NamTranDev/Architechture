package nam.tran.architechture.view.event

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import nam.tran.architechture.R
import nam.tran.architechture.databinding.FragmentEventsBinding
import nam.tran.architechture.view.event.viewmodel.EventsViewModel
import nam.tran.data.Logger
import tran.nam.core.biding.FragmentDataBindingComponent
import tran.nam.core.view.mvvm.BaseFragmentVM

class EventsFragment : BaseFragmentVM<FragmentEventsBinding, EventsViewModel>() {

    private val dataBindingComponent = FragmentDataBindingComponent(this)

    override fun layoutId(): Int {
        return R.layout.fragment_events
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewDataBinding.viewModel = mViewModel

        val adapter = EventAdapter(dataBindingComponent)

        mViewDataBinding.rvEvent.adapter = adapter

        mViewDataBinding.rvEvent.addItemDecoration(
                DividerItemDecoration(
                        context,
                        LinearLayoutManager.VERTICAL
                )
        )

        mViewModel.eventData.observe(viewLifecycleOwner, Observer {
            Logger.debug(it)
            adapter.submitList(it)
        })

        mViewModel.state.observe(viewLifecycleOwner, Observer {
            Logger.debug(it)
            mViewModel.status.set(it)
        })
    }
}
