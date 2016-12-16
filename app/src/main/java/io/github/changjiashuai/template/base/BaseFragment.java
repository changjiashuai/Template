package io.github.changjiashuai.template.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.github.changjiashuai.template.App;
import io.github.changjiashuai.template.di.component.ApplicationComponent;
import io.github.changjiashuai.template.di.component.DaggerFragmentComponent;
import io.github.changjiashuai.template.di.component.FragmentComponent;
import io.github.changjiashuai.template.di.module.FragmentModule;
import io.github.changjiashuai.template.navigation.Navigator;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/13 16:40.
 */

public abstract class BaseFragment<T extends BasePresenter> extends SupportFragment implements BaseView {

    @Inject
    protected T mPresenter;
    @Inject
    protected Navigator mNavigator;
    protected View mView;
    private Unbinder mUnbinder;
    protected Activity mActivity;
    protected Context mContext;
    protected boolean isInited = false;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutResID(), null);
        initInject();
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
        mUnbinder = ButterKnife.bind(this, view);
        if (savedInstanceState==null){
            if (!isHidden()){
                isInited = true;
                loadData();
            }
        }else {
            if (isSupportVisible()){
                isInited = true;
                loadData();
            }
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!isInited && !hidden){
            isInited = true;
            loadData();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }

    // 每个Activity的DI
    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .applicationComponent(getApplicationComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((App) getActivity().getApplication()).getApplicationComponent();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }


    protected abstract int getLayoutResID();

    protected abstract void initInject();

    protected abstract void loadData();
}
