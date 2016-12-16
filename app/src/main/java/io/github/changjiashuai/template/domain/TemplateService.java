package io.github.changjiashuai.template.domain;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/13 17:10.
 */

public interface TemplateService {

    @GET("content")
    Observable<String> getContent(@Query("id") String id);
}
