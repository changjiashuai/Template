package io.github.changjiashuai.template.base;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/13 16:45.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);

    void detachView();
}
