package com.gxnova.appgxnova;

import android.content.Context;
import android.content.SharedPreferences;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://backend-gxnova-production.up.railway.app/";

    public static Retrofit getClient(Context context) {

        if (retrofit == null) {

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor((Interceptor.Chain chain) -> {

                        SharedPreferences prefs = context.getSharedPreferences("GXNova", Context.MODE_PRIVATE);
                        String token = prefs.getString("TOKEN", null);

                        Request.Builder request = chain.request().newBuilder();

                        if (token != null) {
                            request.addHeader("Authorization", "Bearer " + token);
                        }

                        return chain.proceed(request.build());
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
