package com.example.androidtraining.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.androidtraining.R

abstract class BaseFragment :Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observe()
        setListner()
        Load()
    }

    abstract fun init()
    abstract fun observe()
    abstract fun setListner()
    abstract fun Load()

    fun goNext() {
        requireActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }
}