package com.creativesaif.livedatatext;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {

    TextView textView;
    MainActivityViewModel mainActivityViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

       textView = view.findViewById(R.id.textVIew);

       if (getActivity() != null){
           //When main activity not null, initialize the viewmodel
           mainActivityViewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);
           mainActivityViewModel.getText().observe(getActivity(), new Observer<String>() {
               @Override
               public void onChanged(String s) {
                   //when text change update text view
                   textView.setText(s);
               }
           });

       }

        return view;
    }
}