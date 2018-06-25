package tran.nam.core.biding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import nam.tran.domain.entity.state.Loading;
import nam.tran.domain.entity.state.Resource;
import nam.tran.domain.entity.state.Status;
import tran.nam.core.R;
import tran.nam.core.view.BaseActivityWithFragment;
import tran.nam.core.view.BaseParentFragment;
import tran.nam.core.view.FragmentHelper;
import tran.nam.core.viewmodel.IProgressViewModel;
import tran.nam.core.viewmodel.IViewModel;

public class BidingCommon {

    @BindingAdapter("visibleContainLoading")
    public static void visibleContainLoading(View view, IProgressViewModel iProgress){
        Resource resource = iProgress.getResource();
        if (resource == null)
            return;
        switch (resource.status) {
            case Status.ERROR:
                switch (resource.loading) {
                    case Loading.LOADING_DIALOG:
                        view.setVisibility(View.GONE);
                        dialogError(view,resource.message);
                        break;
                    case Loading.LOADING_NONE:
                        Toast.makeText(view.getContext(),resource.message,Toast.LENGTH_SHORT).show();
                        break;
                    case Loading.LOADING_NORMAL:
                        break;
                }
                break;
            case Status.LOADING:
                switch (resource.loading) {
                    case Loading.LOADING_DIALOG:
                        loadingDialog(view,true);
                        break;
                    case Loading.LOADING_NONE:
                        break;
                    case Loading.LOADING_NORMAL:
                        view.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            case Status.SUCCESS:
                switch (resource.loading) {
                    case Loading.LOADING_DIALOG:
                        loadingDialog(view,false);
                        break;
                    case Loading.LOADING_NONE:
                        break;
                    case Loading.LOADING_NORMAL:
                        view.setVisibility(View.GONE);
                        break;
                }
                break;
        }
    }

    @BindingAdapter("visibleProgress")
    public static void visibleProgress(View view,IProgressViewModel iProgress){
        Resource resource = iProgress.getResource();
        if (resource == null)
            return;
        switch (resource.status) {
            case Status.ERROR:
            case Status.SUCCESS:
                view.setVisibility(View.GONE);
                break;
            case Status.LOADING:
                switch (resource.loading) {
                    case Loading.LOADING_DIALOG:
                    case Loading.LOADING_NONE:
                        break;
                    case Loading.LOADING_NORMAL:
                        view.setVisibility(View.VISIBLE);
                        break;
                }
                break;
        }
    }

    @BindingAdapter("visibleError")
    public static void visibleError(TextView textView,IProgressViewModel iProgress){
        Resource resource = iProgress.getResource();
        if (resource == null)
            return;
        switch (resource.status) {
            case Status.ERROR:
                switch (resource.loading) {
                    case Loading.LOADING_DIALOG:
                        break;
                    case Loading.LOADING_NONE:
                        break;
                    case Loading.LOADING_NORMAL:
                        textView.setVisibility(View.VISIBLE);
                        textView.setText(resource.message);
                        break;
                }
                break;
            case Status.LOADING:
            case Status.SUCCESS:
                textView.setVisibility(View.GONE);
                break;
        }
    }

    @BindingAdapter("visibleView")
    public static void visibleView(View view,IProgressViewModel iProgress){
        Resource resource = iProgress.getResource();
        if (resource == null)
            return;
        switch (resource.status) {
            case Status.ERROR:
                switch (resource.loading) {
                    case Loading.LOADING_DIALOG:
                    case Loading.LOADING_NONE:
                        view.setVisibility(View.VISIBLE);
                        break;
                    case Loading.LOADING_NORMAL:
                        view.setVisibility(View.GONE);
                        break;
                }
                break;
            case Status.LOADING:
                switch (resource.loading) {
                    case Loading.LOADING_DIALOG:
                    case Loading.LOADING_NONE:
                        view.setVisibility(View.VISIBLE);
                        break;
                    case Loading.LOADING_NORMAL:
                        view.setVisibility(View.GONE);
                        break;
                }
                break;
            case Status.SUCCESS:
                view.setVisibility(View.VISIBLE);
                break;
        }
    }

    @BindingAdapter("textError")
    public static void textError(TextView text,IProgressViewModel iProgress){
        Resource resource = iProgress.getResource();
        if (resource == null)
            return;
        switch (resource.status) {
            case Status.ERROR:
                text.setText(resource.message);
                break;
            case Status.LOADING:
            case Status.SUCCESS:
                break;
        }
    }

    private static void loadingDialog(View view,Boolean isShow){
        Context context = view.getContext();
        if (context instanceof IViewModel){
            if (isShow){
                ((IViewModel)context).showDialogLoading();
            }else {
                ((IViewModel)context).hideDialogLoading();
            }
        }else {
            if (context instanceof BaseActivityWithFragment){
                FragmentHelper fragmentHelper = ((BaseActivityWithFragment)context).mFragmentHelper;
                Fragment fragment = fragmentHelper.getCurrentFragment();
                if (fragment != null && fragment instanceof BaseParentFragment){
                    FragmentHelper fragmentHelperChild = ((BaseParentFragment)fragment).mChildFragmentHelper;
                    Fragment childFragment = fragmentHelperChild.getCurrentFragment();
                    if (childFragment instanceof IViewModel){
                        if (isShow){
                            ((IViewModel)childFragment).showDialogLoading();
                        }else {
                            ((IViewModel)childFragment).hideDialogLoading();
                        }
                    }
                }
            }
        }
    }

    private static void dialogError(View view,String error){
        Context context = view.getContext();
        if (context instanceof IViewModel){
            ((IViewModel)context).onShowDialogError(error);
        }else {
            if (context instanceof BaseActivityWithFragment){
                FragmentHelper fragmentHelper = ((BaseActivityWithFragment)context).mFragmentHelper;
                Fragment fragment = fragmentHelper.getCurrentFragment();
                if (fragment != null && fragment instanceof BaseParentFragment){
                    FragmentHelper fragmentHelperChild = ((BaseParentFragment)fragment).mChildFragmentHelper;
                    Fragment childFragment = fragmentHelperChild.getCurrentFragment();
                    if (childFragment instanceof IViewModel){
                        ((IViewModel)childFragment).onShowDialogError(error);
                    }
                }
            }
        }
    }
}
