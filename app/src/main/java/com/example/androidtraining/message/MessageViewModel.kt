package com.example.androidtraining.message

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtraining.AppApplication

class MessageViewModel(appApplication: AppApplication):ViewModel() {

    val messageListDataSend = MutableLiveData<ArrayList<Data>>()
//    val messageListDataSend = MutableLiveData<Data>()
    val list = ArrayList<Data>()


    fun addSendMessage(){
        Log.i("Debug", "addSendMessage Function is called ")
        messageListDataSend.value = list
    }
    fun addReceiverMessage(){
        Log.i("Debug", "addReceiverMessage Function is called  ")
        messageListDataSend.value = list
    }
}