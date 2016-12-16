package io.github.changjiashuai.template.presenter;

import javax.inject.Inject;

import io.github.changjiashuai.template.base.RxPresenter;
import io.github.changjiashuai.template.presenter.contract.TemplateContract;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/13 16:46.
 */

public class TemplatePresenter extends RxPresenter<TemplateContract.View> implements TemplateContract.Presenter {

    @Inject
    public TemplatePresenter() {
    }

    @Override
    public void getContentData(int id) {

        Observable<String> fakeData = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("test content form fake");
                subscriber.onCompleted();
            }
        });

//        Subscription mSubscription = RetrofitManager
//                .getTemplateService()
//                .getContent("id")
        Subscription mSubscription = fakeData
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new TemplateSubscriber());

        subscribe(mSubscription);
    }

    private final class TemplateSubscriber extends Subscriber<String> {

        @Override
        public void onCompleted() {
            mView.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            mView.hideLoading();
            mView.showMessage(e.getMessage());
            mView.showRetry();
        }

        @Override
        public void onNext(String s) {
            mView.showContent(s);
        }
    }
}
