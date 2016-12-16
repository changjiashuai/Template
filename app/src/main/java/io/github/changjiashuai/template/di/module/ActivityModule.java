package io.github.changjiashuai.template.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import io.github.changjiashuai.template.di.PerActivity;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/13 16:23.
 */
@Module
public class ActivityModule {
    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity(){
        return mActivity;
    }
}
