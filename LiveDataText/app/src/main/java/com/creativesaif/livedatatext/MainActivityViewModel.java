package com.creativesaif.livedatatext;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private final MutableLiveData<String> stringMutableLiveData = new MutableLiveData<>();

    //create setText method
    public void setText(String s){
        stringMutableLiveData.setValue(s);
    }

    public MutableLiveData<String> getText(){
        return stringMutableLiveData;
    }
}
