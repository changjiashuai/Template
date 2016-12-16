package io.github.changjiashuai.template.di.module;

import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import io.github.changjiashuai.template.di.PerFragment;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/13 16:37.
 */
@Module
public class FragmentModule {

    private final Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @PerFragment
    public Fragment provideFragment(){
        return mFragment;
    }
}
