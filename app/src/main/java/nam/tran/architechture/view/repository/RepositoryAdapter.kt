package nam.tran.architechture.view.repository

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import nam.tran.architechture.R
import nam.tran.architechture.databinding.AdapterEventBinding
import nam.tran.architechture.databinding.AdapterRepositoryBinding
import nam.tran.architechture.databinding.AdapterStateBinding
import nam.tran.data.entities.core.state.State
import nam.tran.domain.entities.EventEntity
import nam.tran.domain.entities.RepositoryEntity
import tran.nam.core.view.ILoadMore

class RepositoryAdapter constructor(private val dataBindingComponent: DataBindingComponent)
    : ILoadMore,PagedListAdapter<RepositoryEntity, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<RepositoryEntity>() {
    override fun areItemsTheSame(oldItem: RepositoryEntity, newItem: RepositoryEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RepositoryEntity, newItem: RepositoryEntity): Boolean {
        return oldItem.name == newItem.name && oldItem.language == newItem.language && oldItem.description == newItem.description
    }
}) {

    private var state: State? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.adapter_repository -> {
                val holder = RepositoryItemViewHolder(
                        DataBindingUtil.inflate(
                                LayoutInflater.from(parent.context),
                                R.layout.adapter_repository,
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
            R.layout.adapter_repository -> (holder as RepositoryItemViewHolder).bind(getItem(position))
            R.layout.adapter_state -> (holder as StateItemViewHolder).bind(state)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (hasExtraRow() && position == itemCount - 1) {
            R.layout.adapter_state
        } else {
            R.layout.adapter_repository
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasExtraRow()) 1 else 0
    }

    private fun hasExtraRow() = state != null && !state!!.isSuccess()

    override fun setNetworkState(newState: State?) {
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

    class RepositoryItemViewHolder(
            val binding: AdapterRepositoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(repository: RepositoryEntity?) {
            binding.repository = repository
            binding.executePendingBindings()
        }
    }
}