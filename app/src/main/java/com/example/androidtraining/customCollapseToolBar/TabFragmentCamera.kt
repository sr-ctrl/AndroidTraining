package com.example.androidtraining.customCollapseToolBar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseFragment
import com.example.androidtraining.databinding.FragmentBBinding
import com.example.androidtraining.databinding.TabFragmentCameraBinding

class TabFragmentCamera: BaseFragment() {
    companion object{
        fun newInstance(): TabFragmentCamera {
            val args = Bundle()
            val fragment = TabFragmentCamera()
            fragment.arguments = args
            return fragment
        }
    }

    lateinit var binding: TabFragmentCameraBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.tab_fragment_camera,null,false)
        Log.i("Debug", "onCreateView: FragmentB")
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