package io.github.changjiashuai.template.base;

import android.support.annotation.CallSuper;
import android.view.View;

import com.airbnb.epoxy.EpoxyHolder;

import butterknife.ButterKnife;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/14 17:31.
 */

public class BaseEpoxyHolder extends EpoxyHolder {

    @CallSuper
    @Override
    protected void bindView(View itemView) {
        ButterKnife.bind(this, itemView);
    }
}
