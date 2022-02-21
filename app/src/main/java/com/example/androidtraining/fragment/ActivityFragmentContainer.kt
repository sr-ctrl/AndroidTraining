package com.example.androidtraining.fragment

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseActivity
import com.example.androidtraining.databinding.ActivityFragmentContainerBinding

class ActivityFragmentContainer :BaseActivity(),Operations{

    lateinit var binding: ActivityFragmentContainerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_fragment_container)
        onCreatedViewDone()
        Log.i("Debug", "Fragment Activity Created ")
    }
    override fun onStart() {
        super.onStart()
        Log.i("Debug", "Fragment Activity Start: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Debug", "Fragment Activity ReStart: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Debug", "Fragment Activity Pause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Debug", "Fragment Activity Stop: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Debug", "Fragment Activity Resume: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Debug", "Fragment Activity Destroy: ")
    }
    override fun init() {

    }

    override fun observe() {

    }

    override fun setListener() {

    }

    override fun load() {
        supportFragmentManager.beginTransaction()
            .add(R.id.add_fragment,FragmentA.newInstance(),"")
            .commit()
    }

    override fun passString(test1:String) {
        Log.i("Debug", "onBackListner: $test1 ")
    }

    override fun passInt(index: Int) {
        Log.i("Debug", "onBackListner: $index ")
    }


}
interface Operations {
    fun passString(test1:String)
    fun passInt (index:Int)
}