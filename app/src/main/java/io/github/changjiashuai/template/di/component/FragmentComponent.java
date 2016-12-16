package io.github.changjiashuai.template.di.component;

import android.support.v4.app.Fragment;

import dagger.Component;
import io.github.changjiashuai.template.di.PerFragment;
import io.github.changjiashuai.template.di.module.FragmentModule;
import io.github.changjiashuai.template.view.main.fragment.TemplateFragment;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/13 16:39.
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Fragment fragment();
    void inject(TemplateFragment fragment);
    // ....
}
