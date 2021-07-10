package com.creativesaif.mvvmlivedataretrofitrecyclerview.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserWrapper {

    @SerializedName("status")
    @Expose
    private String mStatus;
    @SerializedName("message")
    @Expose
    private String mMessage;
    @SerializedName("data")
    @Expose
    private List<User> mData = null;
    @SerializedName("error")
    @Expose
    private Boolean mError;

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        this.mStatus = status;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        this.mMessage = message;
    }

    public List<User> getData() {
        return mData;
    }

    public void setData(List<User> data) {
        this.mData = data;
    }

    public Boolean getError() {
        return mError;
    }

    public void setError(Boolean error) {
        this.mError = error;
    }
}
