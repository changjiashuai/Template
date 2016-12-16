package io.github.changjiashuai.template.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.changjiashuai.template.App;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/13 16:22.
 */
@Module
public class ApplicationModule {
    private final App mApp;

    public ApplicationModule(App app) {
        mApp = app;
    }

    @Provides
    @Singleton
    Context provideAppContext(){
        return mApp;
    }
}
