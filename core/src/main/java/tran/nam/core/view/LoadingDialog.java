package tran.nam.core.view;

import android.app.Activity;
import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import javax.inject.Inject;

import tran.nam.core.R;
import tran.nam.core.databinding.IncludeProgressLayoutBinding;

@SuppressWarnings({"WeakerAccess", "unused"})
public class LoadingDialog {

    private Dialog dialog;
    private Activity mActivity;

    @Inject
    LoadingDialog(AppCompatActivity activity) {
        mActivity = activity;

        dialog = new Dialog(activity, R.style.LoadingTheme);

        Window window = dialog.getWindow();
        if (window != null) {
            window.setGravity(Gravity.CENTER);
            window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
            window.setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND,
                    WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            window.getAttributes().dimAmount = 0.5f;
        }
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.setContentView(initLayout(activity));
    }

    public View initLayout(AppCompatActivity activity) {
        IncludeProgressLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.include_progress_layout, null, false);

        binding.progressLoading.setVisibility(View.VISIBLE);
        return binding.getRoot();
    }

    public void showDialog() {
        try {
            if (!mActivity.isFinishing() && !isShowing()) {
                dialog.show();
            }

        } catch (Exception e) {
            Log.d("LoadingDialog", e.getMessage());
        }
    }

    public boolean isShowing() {
        return dialog != null && dialog.isShowing();
    }

    public void hideDialog() {
        try {
            if (isShowing()) {
                dialog.dismiss();
            }
        } catch (Exception ignored) {
        }
    }

    public void cancelDialog() {
        if (dialog != null && dialog.isShowing()) {
            try {
                dialog.cancel();
                dialog = null;
            } catch (Exception ignored) {
            }
        }
    }


}
