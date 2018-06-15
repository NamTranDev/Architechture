package nam.tran.architechture.test.activity.withFragment.fragmentTest;

import android.os.Bundle;
import android.view.View;

import java.util.Objects;

import javax.inject.Inject;

import nam.tran.architechture.R;
import nam.tran.architechture.view.NavigatorApp;
import tran.nam.core.view.BaseFragment;
import tran.nam.core.widget.NTTextView;

public class TestFragmentWithActivityWithFragment extends BaseFragment {

    public static TestFragmentWithActivityWithFragment getInstance(){
        return new TestFragmentWithActivityWithFragment();
    }

    @Inject
    NavigatorApp mNavigator;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_test_with_activity_with_fragment;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        NTTextView tvTestActivityMvvm = Objects.requireNonNull(getView()).findViewById(R.id.tv_activity_mvvm_test);
        tvTestActivityMvvm.setOnClickListener(v -> {
            mNavigator.goToActivityMvvm(getBaseActivity());
        });
    }
}
