package com.example.androidtraining.customCollapseToolBar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseFragment
import com.example.androidtraining.databinding.FragmentABinding
import com.example.androidtraining.databinding.TabFragmentContactBinding

class TabFragmentContact : BaseFragment() {

    companion object{
        fun newInstance(): TabFragmentContact {
            val args = Bundle()
            val fragment = TabFragmentContact()
            fragment.arguments = args
            return fragment
        }
    }

    lateinit var binding: TabFragmentContactBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.tab_fragment_contact,null,false)
        Log.i("Debug", "onCreateView: FragmentA")
        return binding.root
    }
    override fun init() {
        Log.i("Debug", "loaded ")
    }
    override fun observe() {
    }

    override fun setListner() {
    }
    override fun Load() {
    }
}