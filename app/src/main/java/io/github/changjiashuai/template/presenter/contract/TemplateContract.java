package io.github.changjiashuai.template.presenter.contract;

import io.github.changjiashuai.template.base.BasePresenter;
import io.github.changjiashuai.template.base.BaseView;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/13 16:47.
 */

public interface TemplateContract {

    interface View extends BaseView{
        void showContent(String content);
        //render view
        //view to
    }

    interface Presenter extends BasePresenter<View>{
        void getContentData(int id);
    }
}
