package com.test.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OtpResponseModel implements Serializable {


    @SerializedName("status")
    public static Boolean status;

    @SerializedName("status")
    public String  token;

    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public List<OtpModel> data;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



    public static Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<OtpModel>getData() {
        return data;
    }

    public void setData(List<OtpModel> data) {
        this.data = data;
    }
}
