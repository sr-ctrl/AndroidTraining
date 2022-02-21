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
import com.example.androidtraining.databinding.FragmentCBinding

class FragmentC :BaseFragment() {
    companion object{
        fun newInstance(): FragmentC {
            val args = Bundle()
            val fragment = FragmentC()
            fragment.arguments = args
            return fragment
        }
    }

    lateinit var binding: FragmentCBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_c,null,false)
        Log.i("Debug", "onCreateView: FragmentC")
        return binding.root
    }
    override fun init() {

    }

    override fun observe() {

    }

    override fun setListner() {
        binding.btnAdd.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.add_fragment,FragmentD.newInstance(),"")
                .addToBackStack("")
                .commit()
            Log.i("Debug", "setListner: add backstack Frag C ")
        }
    }

    override fun Load() {

    }





    override fun onResume() {
        super.onResume()
        Log.i("Debug", "onResume: FragmentC")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Debug", "onStop: FragmentC")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Debug", "onDestroy: FragmentC")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Debug", "onDestroyView:FragmentC ")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Debug", "onAttach:FragmentC ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Debug", "onDetach: FragmentC ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Debug", "onPause:FragmentC ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Debug", "onCreate: FragmentC")
    }
}