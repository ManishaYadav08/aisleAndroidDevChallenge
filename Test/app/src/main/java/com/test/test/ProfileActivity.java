package com.test.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.jgabrielfreitas.core.BlurImageView;
import com.test.Model.OtpResponseModel;
import com.test.Network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    public BlurImageView blurImageView1;
    public BlurImageView blurImageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        blurImageView1 = findViewById(R.id.img1);
        blurImageView1.setBlur(2);
        blurImageView2 = findViewById(R.id.img2);
        blurImageView2.setBlur(2);
    }


    private void phone_number_login() {
        Call<OtpResponseModel> call = RetrofitClientInstance.service.getProfile();
        //Log.e("Response", call.toString());
        call.enqueue(new Callback<OtpResponseModel>() {
            @Override
            public void onResponse(Call<OtpResponseModel> call, Response<OtpResponseModel> response) {

                Boolean status = OtpResponseModel.getStatus();
                if(status) {
                }
                else{
                    Toast.makeText(getApplicationContext(),"token = null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OtpResponseModel> call, Throwable t) {

            }


        });
    }
}