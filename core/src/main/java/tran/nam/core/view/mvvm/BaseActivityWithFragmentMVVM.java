/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package tran.nam.core.view.mvvm;

import android.arch.lifecycle.ViewModelProvider;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;

import javax.inject.Inject;

import tran.nam.core.view.BaseActivityWithFragment;
import tran.nam.core.viewmodel.BaseActivityViewModel;
import tran.nam.core.viewmodel.IViewModel;

@SuppressWarnings("unchecked")
public abstract class BaseActivityWithFragmentMVVM<V extends ViewDataBinding, VM extends BaseActivityViewModel> extends BaseActivityWithFragment implements IViewModel{

    @Inject
    protected ViewModelProvider.Factory mViewModelFactory;

    protected VM mViewModel;

    protected V mViewDataBinding;

    @Override
    protected void initLayout() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if (mViewModel != null)
            mViewModel.onCreated(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mViewModel != null)
            mViewModel.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (mViewModel != null)
            mViewModel.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        this.mViewDataBinding.unbind();
        super.onDestroy();
    }

    @Override
    public void showDialogLoading() {
        showLoadingDialog();
    }

    @Override
    public void hideDialogLoading() {
        hideLoadingDialog();
    }
}

