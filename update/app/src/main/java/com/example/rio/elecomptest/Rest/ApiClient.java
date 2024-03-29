package com.example.rio.elecomptest.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by anyem on 7/21/2019.
 */

public class ApiClient {
    public static final String BASE_URL = "http://10.42.0.107/android_api/index.php/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
