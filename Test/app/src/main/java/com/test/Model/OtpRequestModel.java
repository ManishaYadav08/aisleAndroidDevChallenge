package com.test.Model;

import com.google.gson.annotations.SerializedName;

public class OtpRequestModel {
    @SerializedName("phone")
    private String phone;


    private String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
