package tran.nam.core.view

import nam.tran.data.entities.core.state.State

interface ILoadMore{
    fun setNetworkState(newState: State?)
}