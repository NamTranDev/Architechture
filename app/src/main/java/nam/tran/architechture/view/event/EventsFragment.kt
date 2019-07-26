package nam.tran.architechture.view.event

import nam.tran.architechture.R
import nam.tran.architechture.databinding.FragmentEventsBinding
import nam.tran.architechture.view.event.viewmodel.EventsViewModel
import tran.nam.core.view.mvvm.BaseFragmentVM

class EventsFragment : BaseFragmentVM<FragmentEventsBinding, EventsViewModel>() {

    override fun layoutId(): Int {
        return R.layout.fragment_events
    }

}
