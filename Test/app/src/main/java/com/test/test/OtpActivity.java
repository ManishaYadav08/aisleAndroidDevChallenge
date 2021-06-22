package com.test.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.test.Model.OtpResponseModel;
import com.test.Network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpActivity extends AppCompatActivity {
    private TextView phoneNumber, enterText, otpText;
    private EditText editText2;
    private Button btn_continue;
    private ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        init();

    }

    private  void init() {
        phoneNumber = findViewById(R.id.phoneNumber);
        enterText = findViewById(R.id.enterText);
        otpText = findViewById(R.id.otpText);
        editText2 = findViewById(R.id.editText2);
        imageView2 = findViewById(R.id.imageView2);
        btn_continue = findViewById(R.id.btn_continue);

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call API
                phone_number_login();
            }
        });
    }

    private void phone_number_login() {
        String number = phoneNumber.getText().toString();
        String otp = otpText.getText().toString();
        Call<OtpResponseModel> call = RetrofitClientInstance.service.checkOtp(number,otp);
        //Log.e("Response", call.toString());
        call.enqueue(new Callback<OtpResponseModel>() {
            @Override
            public void onResponse(Call<OtpResponseModel> call, Response<OtpResponseModel> response) {

                Boolean status = OtpResponseModel.getStatus();
                if(status) {
                    Intent i = new Intent(OtpActivity.this, ProfileActivity.class);
                    startActivity(i);
                    finish();
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