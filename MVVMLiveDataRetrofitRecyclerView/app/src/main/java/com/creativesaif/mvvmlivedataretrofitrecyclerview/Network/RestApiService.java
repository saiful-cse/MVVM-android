package com.creativesaif.mvvmlivedataretrofitrecyclerview.Network;

import com.creativesaif.mvvmlivedataretrofitrecyclerview.Model.UserWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiService {
    @GET("cgvyXMJkwO?indent=2")
    Call<UserWrapper> getUserList();
}
