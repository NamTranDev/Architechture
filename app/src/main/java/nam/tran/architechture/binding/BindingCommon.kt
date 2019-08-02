package nam.tran.architechture.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import nam.tran.architechture.R
import nam.tran.architechture.di.module.GlideApp
import nam.tran.architechture.view.event.EventAdapter
import nam.tran.data.entities.core.state.Loading
import nam.tran.data.entities.core.state.State
import nam.tran.data.entities.core.state.Status
import nam.tran.domain.entities.UserEntity
import tran.nam.core.biding.BidingCommon
import tran.nam.core.biding.BidingCommon.dialogError
import tran.nam.core.view.ILoadMore

object BindingCommon {

    @JvmStatic
    @BindingAdapter("loadAvarta")
    fun loadAvarta(image: AppCompatImageView, url: String?) {
        url?.let {
            val circularProgressDrawable = CircularProgressDrawable(image.context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()
            GlideApp.with(image).load(url)
                    .thumbnail(0.5f)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .placeholder(circularProgressDrawable)
                    .error(R.drawable.image_error).into(image)
        }
    }

    @JvmStatic
    @BindingAdapter("loadMore")
    fun loadMore(recyclerView: RecyclerView,state : State?){
        val adapter = recyclerView.adapter
        adapter?.run {
            if (this is ILoadMore){
                if (state?.initial == true){
                    this.setNetworkState(null)
                } else
                    this.setNetworkState(state)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("refreshLayout")
    fun refreshLayout(refreshLayout : SwipeRefreshLayout,state: State?){
        if (state == null){
            refreshLayout.isRefreshing = true
        }else{
            refreshLayout.isRefreshing = state.isLoadingInitial()
        }
    }
}