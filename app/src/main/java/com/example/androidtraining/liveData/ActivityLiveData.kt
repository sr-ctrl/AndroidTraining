package com.example.androidtraining.liveData

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseActivity
import com.example.androidtraining.databinding.ActivityLiveDataBinding


class ActivityLiveData : BaseActivity() {

 lateinit var binding:ActivityLiveDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data)
        onCreatedViewDone()
    }
    override fun init() {
        Log.i("Debug", "init: init is called")
    }

    override fun observe() {

    }

    override fun setListener() {

    }

    override fun load() {

    }
}