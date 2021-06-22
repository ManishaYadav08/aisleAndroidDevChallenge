package com.test.Network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    public static GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
    private  static Retrofit retrofit;
    private static   String BASE_URL = "https://testa2.aisle.co/V1/users";

    private static final okhttp3.OkHttpClient OkHttpClient = new OkHttpClient.Builder()
            .connectTimeout(4, TimeUnit.MINUTES)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build();

    public static Retrofit getRetrofitInstance(){
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(OkHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
