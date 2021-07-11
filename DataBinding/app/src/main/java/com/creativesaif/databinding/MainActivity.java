package com.creativesaif.databinding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.adapters.ActionMenuViewBindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.creativesaif.databinding.databinding.ActivityMainBinding;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    //Initializing
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = binding.ediText.getText().toString().trim();
                if (!s.equals("")){
                    binding.tvOutput.setText(s);
                }else{
                    Toast.makeText(getApplicationContext(), "Enter text", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //Initialize fragment
        Fragment fragment = new MainFragment();
        //Commit fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();

    }
}