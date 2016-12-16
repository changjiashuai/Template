package io.github.changjiashuai.template.navigation;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;

import io.github.changjiashuai.template.view.image.ImageProviderActivity;
import io.github.changjiashuai.template.view.main.activity.MainActivity;
import io.github.changjiashuai.template.view.template.activity.TemplateActivity;
import io.github.changjiashuai.template.view.welcome.WelcomeActivity;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/14 10:23.
 */

public class Navigator {

    @Inject
    public Navigator() {
    }

    public void navigateToWelcome(Context context) {
        if (context != null) {
            Intent intent = WelcomeActivity.getCallingIntent(context);
            context.startActivity(intent);
        }
    }

    public void navigateToMain(Context context) {
        if (context != null) {
            Intent intent = MainActivity.getCallingIntent(context);
            context.startActivity(intent);
        }
    }

    public void navigateToTemplate(Context context) {
        if (context != null) {
            Intent intent = TemplateActivity.getCallingIntent(context);
            context.startActivity(intent);
        }
    }

    public void navigateToImageProvider(Context context) {
        if (context != null) {
            Intent intent = ImageProviderActivity.getCallingIntent(context);
            context.startActivity(intent);
        }
    }
}
