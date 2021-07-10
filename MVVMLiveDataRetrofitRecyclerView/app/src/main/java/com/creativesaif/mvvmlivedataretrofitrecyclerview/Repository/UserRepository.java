package com.creativesaif.mvvmlivedataretrofitrecyclerview.Repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.creativesaif.mvvmlivedataretrofitrecyclerview.Model.User;
import com.creativesaif.mvvmlivedataretrofitrecyclerview.Model.UserWrapper;
import com.creativesaif.mvvmlivedataretrofitrecyclerview.Network.RestApiService;
import com.creativesaif.mvvmlivedataretrofitrecyclerview.Network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private ArrayList<User> users = new ArrayList<>();
    private MutableLiveData<List<User>> mutableLiveData  = new MutableLiveData<>();
    
    private Application application;

    public UserRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<User>> getMutableLiveData(){

        RestApiService apiService = RetrofitInstance.getApiService();
        Call<UserWrapper> call = apiService.getUserList();
        call.enqueue(new Callback<UserWrapper>() {
            @Override
            public void onResponse(Call<UserWrapper> call, Response<UserWrapper> response) {
                UserWrapper userWrapper = response.body();
                if (userWrapper != null && userWrapper.getData() !=null){
                    users = (ArrayList<User>) userWrapper.getData();
                    mutableLiveData.setValue(users);
                }


            }

            @Override
            public void onFailure(Call<UserWrapper> call, Throwable t) {
                Log.d("List_size","-> Error"+t.getMessage());
            }
        });
        return mutableLiveData;
    }
}
