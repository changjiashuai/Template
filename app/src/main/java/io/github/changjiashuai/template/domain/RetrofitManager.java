package io.github.changjiashuai.template.domain;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/13 17:11.
 */

public class RetrofitManager {

    public static TemplateService getTemplateService(){
        return ServiceGenerator.createService(TemplateService.class);
    }

    public static WelcomeService getWelcomeService(){
        return ServiceGenerator.createService(WelcomeService.class, "http://h.hiphotos.baidu.com/zhidao/pic/item/6d81800a19d8bc3ed69473cb848ba61ea8d34516.jpg");
    }
}
