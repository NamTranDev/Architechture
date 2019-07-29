package nam.tran.architechture.view.event

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import nam.tran.architechture.R
import nam.tran.architechture.databinding.AdapterEventBinding
import nam.tran.architechture.databinding.AdapterStateBinding
import nam.tran.data.entities.core.state.State
import nam.tran.domain.entities.EventEntity

class EventAdapter constructor(private val dataBindingComponent: DataBindingComponent) : PagedListAdapter<EventEntity, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<EventEntity>() {
    override fun areItemsTheSame(oldItem: EventEntity, newItem: EventEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: EventEntity, newItem: EventEntity): Boolean {
        return oldItem.createdAt == newItem.createdAt && oldItem.type == newItem.type
    }
}) {

    private var state: State? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.adapter_event -> {
                val holder = EventItemViewHolder(
                        DataBindingUtil.inflate(
                                LayoutInflater.from(parent.context),
                                R.layout.adapter_event,
                                parent,
                                false,
                                dataBindingComponent
                        )
                )
                return holder
            }
            R.layout.adapter_state -> StateItemViewHolder(
                    DataBindingUtil.inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.adapter_state,
                            parent,
                            false,
                            dataBindingComponent
                    )
            )
            else -> throw IllegalArgumentException("unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            R.layout.adapter_event -> (holder as EventItemViewHolder).bind(getItem(position))
            R.layout.adapter_state -> (holder as StateItemViewHolder).bind(state)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (hasExtraRow() && position == itemCount - 1) {
            R.layout.adapter_state
        } else {
            R.layout.adapter_event
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasExtraRow()) 1 else 0
    }

    private fun hasExtraRow() = state != null && !state!!.isSuccess()

    fun setNetworkState(newState: State?) {
        val previousState = this.state
        val hadExtraRow = hasExtraRow()
        this.state = newState
        val hasExtraRow = hasExtraRow()
        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {
                notifyItemRemoved(super.getItemCount())
            } else {
                notifyItemInserted(super.getItemCount())
            }
        } else if (hasExtraRow && previousState != newState) {
            notifyItemChanged(itemCount - 1)
        }
    }

    class StateItemViewHolder(val binding: AdapterStateBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(state: State?) {
            binding.state = state
            binding.executePendingBindings()
        }
    }

    class EventItemViewHolder(
            val binding: AdapterEventBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(event: EventEntity?) {
            binding.event = event
            binding.executePendingBindings()
        }
    }
}