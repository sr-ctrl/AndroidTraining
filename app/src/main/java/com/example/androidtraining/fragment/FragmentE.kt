package com.example.androidtraining.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseFragment
import com.example.androidtraining.databinding.FragmentABinding
import com.example.androidtraining.databinding.FragmentEBinding

class FragmentE : BaseFragment(){
    companion object{
        fun newInstance(): FragmentE {
            val args = Bundle()
            val fragment = FragmentE()
            fragment.arguments = args
            return fragment
        }
    }

    lateinit var binding: FragmentEBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_e,null,false)
        Log.i("Debug", "onCreateView: FragmentE")
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



    override fun onResume() {
        super.onResume()
        Log.i("Debug", "onResume: FragmentE")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Debug", "onStop: FragmentE")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Debug", "onDestroy: FragmentE")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Debug", "onDestroyView:FragmentE ")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Debug", "onAttach:FragmentE ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Debug", "onDetach: FragmentE ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Debug", "onPause:FragmentE ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Debug", "onCreate: FragmentE")
    }
}