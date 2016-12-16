package io.github.changjiashuai.template.domain;

import io.github.changjiashuai.template.domain.entity.Welcome;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/14 10:11.
 */

public interface WelcomeService {

    //http://h.hiphotos.baidu.com/zhidao/pic/item/6d81800a19d8bc3ed69473cb848ba61ea8d34516.jpg

    @GET
    Observable<Welcome> getContent();
}
