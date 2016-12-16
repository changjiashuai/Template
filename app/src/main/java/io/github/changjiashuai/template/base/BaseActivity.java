package io.github.changjiashuai.template.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.github.changjiashuai.template.App;
import io.github.changjiashuai.template.R;
import io.github.changjiashuai.template.di.component.ActivityComponent;
import io.github.changjiashuai.template.di.component.ApplicationComponent;
import io.github.changjiashuai.template.di.component.DaggerActivityComponent;
import io.github.changjiashuai.template.di.module.ActivityModule;
import io.github.changjiashuai.template.navigation.Navigator;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/13 16:25.
 */

public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity implements BaseView {

    @Inject
    protected Navigator mNavigator;
    @Inject
    protected T mPresenter;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        mUnbinder = ButterKnife.bind(this);
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        loadData();
    }

    // 每个Activity的DI
    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((App) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected void setToolBar(Toolbar toolbar, String title, boolean isHome) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        if (isHome) {
            // 左上角图标是否显示
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            // 左上角图标是否可点击
//            getSupportActionBar().setHomeButtonEnabled(true);
            // 启用左上角返回图标
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            toolbar.setNavigationIcon(R.drawable.ic_reorder_white_24dp);
        } else {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            toolbar.setNavigationIcon(R.drawable.ic_reorder_white_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressedSupport();
                }
            });
        }
    }

    protected void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        mUnbinder.unbind();
    }

    protected abstract int getLayoutResID();

    protected abstract void initInject();

    protected abstract void loadData();
}
