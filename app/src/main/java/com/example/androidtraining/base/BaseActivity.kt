package com.example.androidtraining.base

import android.os.Bundle
import com.example.androidtraining.R
import androidx.appcompat.app.AppCompatActivity
abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun init()
    protected abstract fun observe()
    protected abstract fun setListener()
    protected abstract fun load()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    protected fun onCreatedViewDone() {
        init()
        observe()
        setListener()
        load()
    }


    fun goBack() {
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
    }

    fun goNext() {
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }

}
