package io.github.changjiashuai.template.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import io.github.changjiashuai.template.di.module.ApplicationModule;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/13 16:25.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context context();
//    void inject(BaseActivity baseActivity);
}
