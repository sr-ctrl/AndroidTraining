package com.example.androidtraining.customCollapseToolBar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseFragment
import com.example.androidtraining.databinding.FragmentCBinding
import com.example.androidtraining.databinding.TabFragmentDataBinding

class TabFragmentData :BaseFragment() {
    companion object{
        fun newInstance(): TabFragmentData {
            val args = Bundle()
            val fragment = TabFragmentData()
            fragment.arguments = args
            return fragment
        }
    }

    lateinit var binding: TabFragmentDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.tab_fragment_data,null,false)
        Log.i("Debug", "onCreateView: FragmentC")
        return binding.root
    }
    override fun init() {

    }

    override fun observe() {

    }

    override fun setListner() {

    }

    override fun Load() {

    }

}