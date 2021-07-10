package com.creativesaif.mvvmlivedataretrofitrecyclerview.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.creativesaif.mvvmlivedataretrofitrecyclerview.Model.User;
import com.creativesaif.mvvmlivedataretrofitrecyclerview.R;
import com.creativesaif.mvvmlivedataretrofitrecyclerview.View.Adapter.UserAdapter;
import com.creativesaif.mvvmlivedataretrofitrecyclerview.ViewModel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private MainViewModel mainViewModel;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        getUserList();


    }

    public void getUserList() {
        //swipeRefreshLayout.setRefreshing(true);
        mainViewModel.getAllUser().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                //swipeRefreshLayout.setRefreshing(false);
                userAdapter = new UserAdapter(MainActivity.this, users);
                recyclerView.setAdapter(userAdapter);
            }
        });
    }
}