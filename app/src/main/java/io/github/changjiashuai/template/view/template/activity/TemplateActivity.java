package io.github.changjiashuai.template.view.template.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import io.github.changjiashuai.template.R;
import io.github.changjiashuai.template.base.BaseActivity;
import io.github.changjiashuai.template.presenter.TemplatePresenter;
import io.github.changjiashuai.template.presenter.contract.TemplateContract;

public class TemplateActivity extends BaseActivity<TemplatePresenter> implements TemplateContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, TemplateActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showContent(String content) {
        setToolBar(mToolbar, "详情", false);
//        mTvContent.setText("content= " + content);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_template;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void loadData() {
        mPresenter.getContentData(1);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }
}
