package com.example.androidtraining.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseFragment
import com.example.androidtraining.databinding.FragmentSpinnerBinding

class FragmentSpinner :BaseFragment() {
    companion object{
        fun newInstance(): FragmentSpinner {
            val args = Bundle()
            val fragment = FragmentSpinner()
            fragment.arguments = args
            return fragment
        }
    }

    lateinit var binding: FragmentSpinnerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_spinner,null,false)
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