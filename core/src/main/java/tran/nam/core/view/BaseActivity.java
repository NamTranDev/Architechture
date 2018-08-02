package tran.nam.core.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public abstract class BaseActivity extends AppCompatActivity {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private LoadingDialog mLoadingDialog;

    /**
     * @return layout resource id
     */
    public abstract @LayoutRes int getLayoutId();

    protected void setStatusBar() { }

    /*
     * Init Fragment Helper
     **/
    protected void initFragment() { }

    protected void initLayout() {
        setContentView(getLayoutId());
    }

    /*
     * Init injection for activity
     **/
    protected void inject() { }

    public abstract void initView(Bundle savedInstanceState);

    public abstract void initData(Bundle savedInstanceState);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setStatusBar();
        inject();
        super.onCreate(savedInstanceState);
        initLayout();
        initFragment();
        mLoadingDialog = new LoadingDialog(this);
        initView(savedInstanceState);
        initData(savedInstanceState);
    }

    protected void showLoadingDialog() {
        if (mLoadingDialog != null && !mLoadingDialog.isShowing()) {
            mLoadingDialog.showDialog();
        }
    }

    protected void hideLoadingDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.hideDialog();
        }
    }

    public void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null)
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void showKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null)
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }
}