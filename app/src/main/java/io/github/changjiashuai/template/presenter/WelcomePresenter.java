package io.github.changjiashuai.template.presenter;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.github.changjiashuai.template.base.RxPresenter;
import io.github.changjiashuai.template.domain.entity.Welcome;
import io.github.changjiashuai.template.presenter.contract.WelcomeContract;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/14 10:10.
 */

public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {

    @Inject
    public WelcomePresenter() {
    }

    @Override
    public void getWelcomeData() {
        Welcome welcome = new Welcome();
        welcome.setText("Welcome Text");
        welcome.setImageUrl("http://h.hiphotos.baidu.com/zhidao/pic/item/6d81800a19d8bc3ed69473cb848ba61ea8d34516.jpg");
        Observable<Welcome> fakeData = Observable.just(welcome);
        Subscription mSubscription = fakeData
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mSubscriber);
        subscribe(mSubscription);
    }

    private final Subscriber<Welcome> mSubscriber = new Subscriber<Welcome>() {
        @Override
        public void onCompleted() {
            mView.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            mView.hideLoading();
            mView.showMessage(e.getMessage());
            mView.viewMain();
        }

        @Override
        public void onNext(Welcome welcome) {
            mView.renderWelcome(welcome);
            startCountDown();
        }
    };

    private static final int COUNT_DOWN_TIME = 2200;

    private void startCountDown() {
        Subscription mSubscription = Observable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mAction1);
        subscribe(mSubscription);
    }

    private final Action1<Long> mAction1 = new Action1<Long>() {
        @Override
        public void call(Long aLong) {
            mView.viewMain();
        }
    };
}
