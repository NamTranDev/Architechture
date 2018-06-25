/*
 * Copyright 2017 Vandolf Estrellado
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tran.nam.core.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import tran.nam.core.R;

/**
 * Abstract Fragment for all Fragments and child Fragments to extend. This contains some boilerplate
 * dependency injection code and activity {@link Context}.
 * <p>
 * <b>DEPENDENCY INJECTION</b>
 * We could extend {@link dagger.android.DaggerFragment} so we can get the boilerplate
 * dagger code for free. However, we want to avoid inheritance (if possible and it is in this case)
 * so that we have to option to inherit from something else later on if needed.
 * <p>
 * <b>VIEW BINDING</b>
 * This fragment handles view bind and unbinding.
 */
@SuppressWarnings({"deprecation", "unused"})
public abstract class BaseFragment extends Fragment {

    protected boolean mIsCurrentScreen;
    private boolean mIsInLeft;
    private boolean mIsOutLeft;
    private boolean mIsPush;
    private boolean mInitialized = true;
    private boolean mViewCreated = false;
    private boolean mViewDestroyed = false;
    private WaitThread mWaitThread;

    /**
     * @return layout resource id
     */
    public abstract @LayoutRes
    int getLayoutId();

    /*
     * Init Child Fragment Helper
     **/
    protected void initChildFragment() {}

    public View initLayout(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    protected BaseActivity activity() {
        return ((BaseActivity) getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = initLayout(inflater,container);
        initChildFragment();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onVisible();
        mViewCreated = true;
        mViewDestroyed = false;
        if (mWaitThread != null)
            mWaitThread.continueProcessing();
    }

    protected boolean isHaveAnimation(){
        return true;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        Animation animation;
        if (isHaveAnimation()){
            if (mIsCurrentScreen) {
                int popExit = getPopExitAnimId();
                int pushEnter = getPushEnterAnimId();
                int pushExit = getPushExitAnimId();
                int popEnter = getPopEnterAnimId();
                if (mIsPush)
                    animation = AnimationUtils.loadAnimation(activity(), enter ? pushEnter : pushExit);
                else
                    animation = AnimationUtils.loadAnimation(activity(), enter ? popEnter : popExit);
            } else {
                if (enter) {
                    int left = getLeftInAnimId();
                    int right = getRightInAnimId();
                    if (mIsInLeft) {
                        if (left == 0) {
                            animation = new AlphaAnimation(1, 1);
                            animation.setDuration(getResources().getInteger(R.integer.animation_time_full));
                        } else {
                            animation = AnimationUtils.loadAnimation(activity(), left);
                        }
                    } else {
                        if (right == 0) {
                            animation = new AlphaAnimation(1, 1);
                            animation.setDuration(getResources().getInteger(R.integer.animation_time_full));
                        } else {
                            animation = AnimationUtils.loadAnimation(activity(), right);
                        }
                    }
                } else {
                    int left = getLeftOutAnimId();
                    int right = getRightOutAnimId();
                    animation = AnimationUtils.loadAnimation(activity(), mIsOutLeft ? left : right);
                }
            }
        }else {
            animation = AnimationUtils.loadAnimation(getContext(), R.anim.no_anim);
        }

        if (enter) {
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    if (mViewDestroyed)
                        return;
                    mWaitThread = new WaitThread(BaseFragment.this);
                    mWaitThread.start();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        return animation;
    }

    @Override
    public void onDestroyView() {
        // This lifecycle method still gets called even if onCreateView returns a null view.
        mViewDestroyed = true;
        mViewCreated = false;
        onInVisible();
        if (mWaitThread != null)
            mWaitThread.stopProcessing();
        super.onDestroyView();
    }

    protected void showLoadingDialog() {
        if (getActivity() != null && getActivity() instanceof BaseActivity && !getActivity().isFinishing())
            ((BaseActivity) getActivity()).showLoadingDialog();
    }

    protected void hideLoadingDialog() {
        if (getActivity() != null && getActivity() instanceof BaseActivity && !getActivity().isFinishing())
            ((BaseActivity) getActivity()).hideLoadingDialog();
    }

    protected void showKeyboard() {
        if (activity() != null && !activity().isFinishing()) {
            activity().showKeyboard();
        }
    }

    protected void hideKeyboard() {
        if (activity() != null && !activity().isFinishing())
            activity().hideKeyboard();
    }

    public String getTagName() {
        return getClass().getSimpleName();
    }

    public boolean isInitialized() {
        return mInitialized;
    }

    public void initialized() {
        mInitialized = false;
    }

    public boolean isViewCreated() {
        return mViewCreated;
    }

    public void setInLeft(boolean inLeft) {
        mIsInLeft = inLeft;
    }

    public void setOutLeft(boolean outLeft) {
        mIsOutLeft = outLeft;
    }

    public void setCurrentScreen(boolean currentScreen) {
        mIsCurrentScreen = currentScreen;
    }

    public void setPush(boolean push) {
        mIsPush = push;
    }

    public boolean isShouldSave() {
        return true;
    }

    protected void onVisible() {
    }

    protected void handleAfterVisible() {
    }

    protected void onInVisible() {
    }

    protected int getPushExitAnimId() {
        return R.anim.slide_out_left;
    }

    protected int getPopEnterAnimId() {
        return R.anim.slide_in_left;
    }

    protected int getPopExitAnimId() {
        return R.anim.slide_out_right;
    }

    protected int getPushEnterAnimId() {
        return R.anim.slide_in_right;
    }

    protected int getLeftInAnimId() {
        return R.anim.slide_in_left;
    }

    protected int getRightInAnimId() {
        return R.anim.slide_in_right;
    }

    protected int getLeftOutAnimId() {
        return R.anim.slide_out_left;
    }

    protected int getRightOutAnimId() {
        return R.anim.slide_out_right;
    }
}