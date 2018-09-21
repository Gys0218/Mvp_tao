package com.example.lenovo.mvp_tao.retrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataRetrofit {

    private static final long DEFAULT_TIMEOUT = 20000;

    public static Apiservice getRetrofit(){

//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient httpClient = new OkHttpClient.Builder()
//                //日志拦截器
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        Request request = chain.request();
//                        Request.Builder requestBuild = request.newBuilder();
//                        Request request1 = requestBuild
////                                .addHeader("Content-Type", "application/json;charset=UTF-8")
//                                .post(RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
//                                        bodyToString(request.body())))
//                                .build();
//                        request = request1;
//                        return chain.proceed(request);
//                    }
//                })
//                .addInterceptor(interceptor)
//                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .build();

        Retrofit retrofit = new Retrofit.Builder()
//                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://39.107.224.233/firstga/app/")
                .build();

        return retrofit.create(Apiservice.class);
    }

    private static String bodyToString(RequestBody request){

            try {
                RequestBody copy = request;
                okio.Buffer buffer = new okio.Buffer();
                if (copy != null)
                copy.writeTo(buffer);
                else return "";
                return buffer.readUtf8();


            } catch (IOException e) {
                return "did not work";
        }
    }
}
