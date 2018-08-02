package tran.nam.core.view;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import java.util.Objects;

import tran.nam.core.R;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public abstract class BaseDialog<T extends ViewDataBinding> extends DialogFragment {

    protected OnDialogCallback onDialogCallback;

    protected abstract void bidingData(T biding);

    protected abstract @LayoutRes
    int layoutID();

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(Objects.requireNonNull(getActivity()));
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(cancelOnTouch());
        if (dialog.getWindow() != null) {
            dialog.getWindow().getAttributes().windowAnimations = R.style.Dialog;
        }
        return dialog;
    }

    protected boolean cancelOnTouch() {
        return true;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        T biding = DataBindingUtil.inflate(inflater,
                layoutID(), container, false);

        bidingData(biding);
        return biding.getRoot();
    }

    @Override
    public void onResume() {
        // Store access variables for window and blank point
        Window window = getDialog().getWindow();
        if (window != null) {
            Point size = new Point();
            // Store dimensions of the screen in `size`
            Display display = window.getWindowManager().getDefaultDisplay();
            display.getSize(size);
            // Set the width of the dialog proportional to 75% of the screen width
            if (maxWidth() != 0 && maxHeight() != 0) {
                window.setLayout((int) (size.x * maxWidth()), (int) (size.y * maxHeight()));
            } else if (maxWidth() != 0) {
                window.setLayout((int) (size.x * maxWidth()), WRAP_CONTENT);
            } else if (maxHeight() != 0) {
                window.setLayout(WRAP_CONTENT, (int) (size.y * maxHeight()));
            } else {
                window.setLayout(WRAP_CONTENT, WRAP_CONTENT);
            }
            window.setGravity(Gravity.CENTER);
            // Call super onResume after sizing

        }
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onDialogCallback = null;
    }

    protected float maxHeight() {
        return 0;
    }

    protected float maxWidth() {
        return 0.6f;
    }

    public void setOnDialogCallback(OnDialogCallback onDialogCallback) {
        this.onDialogCallback = onDialogCallback;
    }

    public interface OnDialogCallback<DATA> {
        void onComfirm(DATA data);

        void onCancel();
    }
}
