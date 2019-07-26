@file:Suppress("unused")

package tran.nam.core.biding

import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.navigation.fragment.NavHostFragment
import nam.tran.data.entities.core.state.Loading
import nam.tran.data.entities.core.state.State
import nam.tran.data.entities.core.state.Status
import tran.nam.core.view.BaseActivity
import tran.nam.core.view.navigation.CustomNavHostFragment
import tran.nam.core.viewmodel.IViewLoading

object BidingCommon {

    @JvmStatic
    @BindingAdapter("visibleContainLoading")
    fun visibleContainLoading(view: View, state : State?) {
        state?.let {
            when (it.status) {
                Status.ERROR -> when (it.loading) {
                    Loading.LOADING_DIALOG -> {
                        view.visibility = View.GONE
                        if (!state.displayErrorDialog) {
                            state.displayErrorDialog = true
                            dialogError(view, it.errorState?.message, it.errorState?.code)
                        }
                    }
                    Loading.LOADING_NONE -> Toast.makeText(
                            view.context,
                            it.errorState?.message,
                            Toast.LENGTH_SHORT
                    ).show()
                    Loading.LOADING_NORMAL -> {
                        if (it.initial) {
                            view.visibility = View.VISIBLE
                        } else {
                            view.visibility = View.GONE
                        }
                    }
                }
                Status.LOADING -> when (it.loading) {
                    Loading.LOADING_DIALOG -> {
                        loadingDialog(view, true)
                    }
                    Loading.LOADING_NONE -> {
                    }
                    Loading.LOADING_NORMAL -> if (it.initial) view.visibility = View.VISIBLE
                }
                Status.SUCCESS -> when (it.loading) {
                    Loading.LOADING_DIALOG -> {
                        loadingDialog(view, false)
                    }
                    Loading.LOADING_NONE -> {
                    }
                    Loading.LOADING_NORMAL -> if (it.initial) view.visibility = View.GONE
                }
            }
        }
    }

    @JvmStatic
    @BindingAdapter("visibleProgress")
    fun visibleProgress(view: View, state : State?) {
        state?.let {
            when (it.status) {
                Status.ERROR, Status.SUCCESS -> view.visibility = View.GONE
                Status.LOADING -> when (it.loading) {
                    Loading.LOADING_DIALOG, Loading.LOADING_NONE -> {
                    }
                    Loading.LOADING_NORMAL -> view.visibility = View.VISIBLE
                }
            }
        }
    }

    @JvmStatic
    @BindingAdapter("visibleView")
    fun visibleView(view: View, state : State?) {
        state?.let {
            when (it.status) {
                Status.ERROR -> when (it.loading) {
                    Loading.LOADING_DIALOG, Loading.LOADING_NONE -> view.visibility = View.VISIBLE
                    Loading.LOADING_NORMAL -> if (it.initial) {
                        view.visibility = View.INVISIBLE
                    } else {
                        view.visibility = View.VISIBLE
                    }
                }
                Status.LOADING -> when (it.loading) {
                    Loading.LOADING_DIALOG, Loading.LOADING_NONE -> view.visibility = View.VISIBLE
                    Loading.LOADING_NORMAL -> if (it.initial) view.visibility = View.INVISIBLE
                }
                Status.SUCCESS -> view.visibility = View.VISIBLE
            }
        }
    }

    @JvmStatic
    @BindingAdapter("visibleTextError")
    fun visibleTextError(text: TextView, state : State?) {
        state?.let {
            when (it.status) {
                Status.ERROR -> when (it.loading) {
                    Loading.LOADING_DIALOG -> {
                    }
                    Loading.LOADING_NONE -> {
                    }
                    Loading.LOADING_NORMAL -> {
                        text.visibility = View.VISIBLE
                        text.text = it.errorState?.message
                    }
                }
                Status.LOADING, Status.SUCCESS -> text.visibility = View.GONE
            }
        }
    }

    @JvmStatic
    @BindingAdapter("visibleButtonError")
    fun visibleButtonError(bt: Button, state : State?) {
        state?.let {
            when (it.status) {
                Status.ERROR -> {
                    bt.visibility = View.VISIBLE
                    bt.setOnClickListener {
                        state.retry?.invoke()
                    }
                }
                Status.LOADING, Status.SUCCESS -> bt.visibility = View.GONE
            }
        }
    }

    private fun loadingDialog(view: View, isShow: Boolean?) {
        val context = view.context
        if (context is IViewLoading) {
            if (isShow!!) {
                context.showDialogLoading()
            } else {
                context.hideDialogLoading()
            }
        } else {
            if (context is BaseActivity) {
                val manager = context.supportFragmentManager.fragments
                if (manager.size > 0) {
                    val fragment = manager[0].childFragmentManager.primaryNavigationFragment
                    if (fragment != null) {
                        if (fragment is IViewLoading)
                            if (isShow!!) {
                                fragment.showDialogLoading()
                            } else {
                                fragment.hideDialogLoading()
                            }
                        else {
                            val managerChild = fragment.childFragmentManager
                            if (managerChild.fragments.size > 0) {
                                if (managerChild.fragments[0] is NavHostFragment) {
                                    val fragmentChild =
                                            managerChild.fragments[0].childFragmentManager.primaryNavigationFragment
                                    if (fragmentChild != null && fragmentChild is IViewLoading) {
                                        if (isShow!!) {
                                            fragmentChild.showDialogLoading()
                                        } else {
                                            fragmentChild.hideDialogLoading()
                                        }
                                    }
                                } else if (managerChild.fragments[0] is IViewLoading) {
                                    val fragmentChild = managerChild.fragments[0] as IViewLoading
                                    if (isShow!!) {
                                        fragmentChild.showDialogLoading()
                                    } else {
                                        fragmentChild.hideDialogLoading()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun dialogError(view: View, error: String?, codeError: Int?) {
        val context = view.context
        if (context is IViewLoading) {
            context.onShowDialogError(error, codeError)
        } else {
            if (context is BaseActivity) {
                val manager = context.supportFragmentManager.fragments
                if (manager.size > 0) {
                    val fragment = manager[0].childFragmentManager.primaryNavigationFragment
                    if (fragment != null) {
                        if (fragment is IViewLoading)
                            fragment.onShowDialogError(error, codeError)
                        else {
                            val managerChild = fragment.childFragmentManager
                            if (managerChild.fragments.size > 0) {
                                if (managerChild.fragments[0] is CustomNavHostFragment) {
                                    val fragmentChild =
                                            managerChild.fragments[0].childFragmentManager.primaryNavigationFragment
                                    if (fragmentChild != null && fragmentChild is IViewLoading) {
                                        fragmentChild.onShowDialogError(error, codeError)
                                    }
                                } else if (managerChild.fragments[0] is IViewLoading) {
                                    val fragmentChild = managerChild.fragments[0] as IViewLoading
                                    fragmentChild.onShowDialogError(error, codeError)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
