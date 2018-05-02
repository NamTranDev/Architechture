package nam.tran.architechture.biding;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import nam.tran.domain.entity.state.Loading;
import nam.tran.domain.entity.state.Resource;
import nam.tran.domain.entity.state.Status;
import tran.nam.core.viewmodel.IViewModel;

public class BidingCommon {

    @BindingAdapter("visibleContainLoading")
    public static void visibleContainLoading(View view, Resource resource){
        if (resource == null)
            return;
        switch (resource.status) {
            case Status.ERROR:
                switch (resource.loading) {
                    case Loading.LOADING_DIALOG:
                        view.setVisibility(View.GONE);
                        if (view.getContext() instanceof IViewModel){
                            ((IViewModel) view.getContext()).onShowDialogError(resource.message);
                        }
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
                        if (view.getContext() instanceof IViewModel){
                            ((IViewModel) view.getContext()).showDialogLoading();
                        }
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
                        if (view.getContext() instanceof IViewModel){
                            ((IViewModel) view.getContext()).hideDialogLoading();
                        }
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
    public static void visibleProgress(View view,Resource resource){
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
    public static void visibleError(TextView textView, Resource resource){
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
    public static void visibleView(View view,Resource resource){
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
}
