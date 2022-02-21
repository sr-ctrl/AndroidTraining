package com.example.androidtraining

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.androidtraining.base.BaseActivity
import com.example.androidtraining.databinding.ActivityMainBinding
import com.example.androidtraining.fragment.ActivityFragmentContainer
import com.example.androidtraining.message.MessageActivity
import com.example.androidtraining.utils.ActivityUtils
class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        onCreatedViewDone()
    }

    override fun onStart() {
        super.onStart()
        Log.i("Debug", "Main Activity Start: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Debug", "Main Activity ReStart: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Debug", "Main Activity Pause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Debug", "Main Activity Stop: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Debug", "Main Activity Resume: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Debug", "Main Activity Destroy: ")
    }

    override fun init() {


    }

    override fun observe() {

    }

    override fun setListener() {
        binding.MessageActivity.setOnClickListener {
            startActivity(Intent(this, MessageActivity::class.java))
            goNext()
        }
        binding.ActivityUtils.setOnClickListener {
            startActivity(Intent(this, ActivityUtils::class.java))
            goNext()
        }

        binding.ActivityFragment.setOnClickListener {
            startActivity(Intent(this,ActivityFragmentContainer::class.java))
            goNext()
        }

    }

    override fun load() {

    }
}