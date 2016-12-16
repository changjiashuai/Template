package io.github.changjiashuai.template.di.component;

import android.app.Activity;

import dagger.Component;
import io.github.changjiashuai.template.di.PerActivity;
import io.github.changjiashuai.template.di.module.ActivityModule;
import io.github.changjiashuai.template.view.welcome.WelcomeActivity;
import io.github.changjiashuai.template.view.template.activity.TemplateActivity;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/13 16:26.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
    void inject(WelcomeActivity activity);
    void inject(TemplateActivity activity);
    // ...
}
