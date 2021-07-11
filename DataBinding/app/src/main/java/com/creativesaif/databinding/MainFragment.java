package com.creativesaif.databinding;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.creativesaif.databinding.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {


    //Initialize variable
    private FragmentMainBinding binding;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Assign variable
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        view = binding.getRoot();

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = binding.ediText.getText().toString().trim();
                if (!s.equals("")){
                    binding.tvOutput.setText(s);
                }else{
                    Toast.makeText(getActivity(), "Enter text", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //return view
        return view;
    }
}