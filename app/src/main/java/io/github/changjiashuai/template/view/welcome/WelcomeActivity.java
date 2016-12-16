package io.github.changjiashuai.template.view.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import io.github.changjiashuai.template.R;
import io.github.changjiashuai.template.base.BaseActivity;
import io.github.changjiashuai.template.domain.entity.Welcome;
import io.github.changjiashuai.template.presenter.WelcomePresenter;
import io.github.changjiashuai.template.presenter.contract.WelcomeContract;

public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View {

    @BindView(R.id.iv_welcome_bg)
    ImageView mIvWelcomeBg;
    @BindView(R.id.tv_welcome_author)
    TextView mTvWelcomeAuthor;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, WelcomeActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void loadData() {
        mPresenter.getWelcomeData();
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

    @Override
    public void renderWelcome(Welcome welcome) {
        Glide.with(this)
                .load(welcome.getImageUrl())
                .crossFade()
                .into(mIvWelcomeBg);
        mIvWelcomeBg.animate()
                .scaleX(1.12f)
                .scaleY(1.12f)
                .setDuration(2000)
                .setStartDelay(100)
                .start();
        mTvWelcomeAuthor.setText(welcome.getText());
    }

    @Override
    public void viewMain() {
        mNavigator.navigateToMain(this);
        finish();
    }
}
