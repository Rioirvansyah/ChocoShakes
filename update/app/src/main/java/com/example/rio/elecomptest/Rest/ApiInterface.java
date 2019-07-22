package com.example.rio.elecomptest.Rest;

import com.example.rio.elecomptest.model.GetSlider;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by anyem on 7/21/2019.
 */

public interface ApiInterface {
    @GET("slider/all")
    Call<GetSlider> getSlider();
}
