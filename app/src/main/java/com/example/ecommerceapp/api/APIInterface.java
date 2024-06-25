package com.example.ecommerceapp.api;

 import com.example.ecommerceapp.model.SingleMessageResponse.SingleMessageResponse;
 import com.example.ecommerceapp.model.homeBanner.BannerModelResponse;
 import com.example.ecommerceapp.model.loginResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {
    @FormUrlEncoded
    @POST("register.php")
    Call<SingleMessageResponse> register(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password

    );

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password

    );

    @GET("fetch_all_banner.php")
    Call<BannerModelResponse> getBanner();



}
