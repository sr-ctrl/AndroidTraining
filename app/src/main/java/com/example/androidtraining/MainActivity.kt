package com.example.androidtraining

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.androidtraining.base.BaseActivity
import com.example.androidtraining.databinding.ActivityMainBinding
import com.example.androidtraining.liveData.ActivityLiveData
import com.example.androidtraining.utils.ActivityUtils


class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        onCreatedViewDone()
    }


    override fun init() {

    }

    override fun observe() {

    }

    override fun setListener() {
        binding.MessageActivity.setOnClickListener {
            startActivity(Intent(this,MessageActivity::class.java))
            goNext()
        }
        binding.ActivityliveData.setOnClickListener {
            startActivity(Intent(this,ActivityLiveData::class.java))
            goNext()
        }
        binding.ActivityUtils.setOnClickListener {
            startActivity(Intent(this, ActivityUtils::class.java))
            goNext()
        }
    }

    override fun load() {

    }
}