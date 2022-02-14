package com.example.androidtraining.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtraining.AppApplication

class TextWatcherViewModel(appApplication: AppApplication) :ViewModel() {

    val textWatcherText = MutableLiveData<String>()

    fun enteredTextFun(text:String){
        textWatcherText.value = text
    }
}