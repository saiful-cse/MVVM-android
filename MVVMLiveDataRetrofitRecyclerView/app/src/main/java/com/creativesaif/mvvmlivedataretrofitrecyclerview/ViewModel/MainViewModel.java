package com.creativesaif.mvvmlivedataretrofitrecyclerview.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.creativesaif.mvvmlivedataretrofitrecyclerview.Model.User;
import com.creativesaif.mvvmlivedataretrofitrecyclerview.Repository.UserRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public LiveData<List<User>> getAllUser(){
        return userRepository.getMutableLiveData();
    }
}
