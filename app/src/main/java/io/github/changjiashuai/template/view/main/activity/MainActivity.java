package io.github.changjiashuai.template.view.main.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.github.changjiashuai.template.R;
import io.github.changjiashuai.template.base.BaseActivity;
import io.github.changjiashuai.template.view.main.adapter.ViewPagerAdapter;
import io.github.changjiashuai.template.view.main.fragment.TemplateFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tab_comment)
    TabLayout mTabLayout;
    @BindView(R.id.vp_comment)
    ViewPager mViewPager;

    private ViewPagerAdapter mTemplateAdapter;
    private List<TemplateFragment> mFragments = new ArrayList<>();

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInject() {

    }

    @Override
    protected void loadData() {
        setToolBar(mToolbar, "首页", true);
        mFragments.add(new TemplateFragment());
        mFragments.add(new TemplateFragment());
        mTemplateAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mTemplateAdapter);
        mTabLayout.addTab(mTabLayout.newTab().setText("Test A"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Test B"));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText("Test A");
        mTabLayout.getTabAt(1).setText("Test B");
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
