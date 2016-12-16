package io.github.changjiashuai.template.domain;

import io.github.changjiashuai.template.Constants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/13 17:08.
 */

public final class ServiceGenerator {
    private static final String TAG = "ServiceGenerator";
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static Retrofit.Builder sBuilder = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create());

    private ServiceGenerator() {

    }

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, Constants.BASE_URL);
    }

    public static <S> S createService(Class<S> serviceClass, String baseUrl) {
        Retrofit retrofit = sBuilder.baseUrl(baseUrl).client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }
}
