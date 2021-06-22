package com.test.Network;

import com.test.Model.OtpResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetDataService {


    @POST("/phone_number_login")
    Call<OtpResponseModel> getOtp(
            @Field("number")String num);

    @POST("/verify_otp")
    Call<OtpResponseModel> checkOtp(
            @Field("number")String num,
            @Field("otp")String otp);

    @GET("/test_profile_list")
    Call<OtpResponseModel> getProfile();

}
