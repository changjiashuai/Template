package io.github.changjiashuai.template;

import android.app.Application;

import io.github.changjiashuai.template.di.component.ApplicationComponent;
import io.github.changjiashuai.template.di.component.DaggerApplicationComponent;
import io.github.changjiashuai.template.di.module.ApplicationModule;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/13 16:21.
 */

public class App extends Application {
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    // App DI
    private void initializeInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
