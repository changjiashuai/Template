package io.github.changjiashuai.template.view.main.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.github.changjiashuai.template.R;
import io.github.changjiashuai.template.base.BaseFragment;
import io.github.changjiashuai.template.presenter.TemplatePresenter;
import io.github.changjiashuai.template.presenter.contract.TemplateContract;
import io.github.changjiashuai.template.view.main.adapter.TemplateAdapter;
import io.github.changjiashuai.template.view.main.model.TemplateModel;
import io.github.changjiashuai.template.view.main.model.TemplateModel_;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/13 18:10.
 */

public class TemplateFragment extends BaseFragment<TemplatePresenter> implements TemplateContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private TemplateAdapter mAdapter;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_template;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void loadData() {
        mPresenter.getContentData(1);
    }

    @Override
    public void showContent(String content) {
        List<TemplateModel> templateModels = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            TemplateModel templateModel = new TemplateModel_()
                    .content(content + " " + i)
                    .clickListener(mOnClickListener);
            templateModels.add(templateModel);
        }
        mAdapter = new TemplateAdapter(templateModels);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(mContext);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mNavigator.navigateToTemplate(mActivity);
        }
    };

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
