package com.example.androidtraining.utils

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseActivity
import com.example.androidtraining.databinding.ActivityUtilsBinding
import com.example.androidtraining.fragment.FragmentSpinner

class ActivityUtils : BaseActivity(){
    private lateinit var binding: ActivityUtilsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_utils)
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
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.fragment_container,
//            FragmentTextWatcher.newInstance(), "")
//            .commit()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,
            FragmentSpinner.newInstance(),"")
            .commit()
    }
}
