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
import com.example.androidtraining.databinding.FragmentDBinding

class FragmentD:BaseFragment() {
    companion object{
        fun newInstance(): FragmentD {
            val args = Bundle()
            val fragment = FragmentD()
            fragment.arguments = args
            return fragment
        }
    }

    lateinit var binding: FragmentDBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_d,null,false)
        Log.i("Debug", "onCreateView: FragmentD")
        return binding.root
    }
    override fun init() {

    }

    override fun observe() {

    }

    override fun setListner() {
        binding.btnAdd.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.add_fragment,FragmentE.newInstance(),"")
                .commit()
        }
    }

    override fun Load() {

    }



    override fun onResume() {
        super.onResume()
        Log.i("Debug", "onResume: FragmentD")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Debug", "onStop: FragmentD")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Debug", "onDestroy: FragmentD")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Debug", "onDestroyView:FragmentD ")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Debug", "onAttach:FragmentD ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Debug", "onDetach: FragmentD ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Debug", "onPause:FragmentD ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Debug", "onCreate: FragmentD")
    }
}