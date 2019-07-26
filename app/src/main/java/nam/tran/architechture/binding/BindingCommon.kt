package nam.tran.architechture.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import nam.tran.architechture.R
import nam.tran.architechture.di.module.GlideApp
import nam.tran.domain.entities.UserEntity

object BindingCommon{

    @JvmStatic
    @BindingAdapter("loadAvarta")
    fun loadAvarta(image: AppCompatImageView, userEntity: UserEntity?) {
        userEntity?.let {
            val circularProgressDrawable = CircularProgressDrawable(image.context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()
            GlideApp.with(image).load(it.avatarUrl)
                    .thumbnail(0.5f)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .placeholder(circularProgressDrawable)
                    .error(R.drawable.image_error).into(image)
        }
    }
}