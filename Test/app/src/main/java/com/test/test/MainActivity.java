package com.test.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.test.Model.OtpRequestModel;
import com.test.Model.OtpResponseModel;
import com.test.Network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView get_otp, enter, textNum;
    private EditText country_code,phoneNumber;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();



    }
    private  void init(){
        get_otp = findViewById(R.id.get_otp);
        enter= findViewById(R.id.enter);
        textNum= findViewById(R.id.textNum);
        country_code = findViewById(R.id.country_code);
        phoneNumber = findViewById(R.id.phoneNumber);
        button= findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call API
                phone_number_login();
            }
        });

    }
    public void phone_number_login(){
        //ImageRequestModel imageRequestModel = new ImageRequestModel();
        //imageRequestModel.setId("10");
        String number = country_code.getText().toString() + phoneNumber.getText().toString();
        Call<OtpResponseModel>call = RetrofitClientInstance.service.getOtp(number);
        //Log.e("Response", call.toString());
        call.enqueue(new Callback<OtpResponseModel>() {
            @Override
            public void onResponse(Call<OtpResponseModel> call, Response<OtpResponseModel> response) {

                    Boolean status = OtpResponseModel.getStatus();
                    if(status) {
                        Intent i = new Intent(MainActivity.this, OtpActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"status = false", Toast.LENGTH_SHORT).show();
                    }
            }

            @Override
            public void onFailure(Call<OtpResponseModel> call, Throwable t) {

            }


        });

    }
}