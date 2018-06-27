package nam.tran.architechture.view.main.fragment.parent;

import nam.tran.architechture.R;
import nam.tran.architechture.view.main.fragment.parent.season.SoccerSeasonChildFragment;
import tran.nam.core.view.BaseFragment;
import tran.nam.core.view.BaseParentFragment;

public class ParentFragment extends BaseParentFragment {

    public static ParentFragment getInstance() {
        return new ParentFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_parent;
    }

    @Override
    protected boolean isHaveAnimation() {
        return false;
    }

    @Override
    public BaseFragment[] getFragments() {
        return new BaseFragment[]{SoccerSeasonChildFragment.getInstance()};
    }

    @Override
    public int getContentLayoutId() {
        return R.id.parent_contain;
    }
}
