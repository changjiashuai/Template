package io.github.changjiashuai.template.presenter.contract;

import io.github.changjiashuai.template.base.BasePresenter;
import io.github.changjiashuai.template.base.BaseView;
import io.github.changjiashuai.template.domain.entity.Welcome;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/14 10:04.
 */

public interface WelcomeContract {

    interface View extends BaseView {
        void renderWelcome(Welcome welcome);
        void viewMain();
    }

    interface Presenter extends BasePresenter<View> {
        void getWelcomeData();
    }
}
