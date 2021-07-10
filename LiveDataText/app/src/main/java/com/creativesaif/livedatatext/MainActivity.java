package com.creativesaif.livedatatext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Initialize variable
    EditText editText;
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigne variable
        editText = findViewById(R.id.ediText);
        //Initialize view
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //When text change, update view model text
                mainActivityViewModel.setText(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Initialize fargment
        Fragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment).commit();


    }
}