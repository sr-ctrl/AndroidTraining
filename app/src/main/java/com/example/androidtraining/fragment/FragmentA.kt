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

class FragmentA : BaseFragment() {

    companion object{
        fun newInstance(): FragmentA {
            val args = Bundle()
            val fragment = FragmentA()
            fragment.arguments = args
            return fragment
        }
    }

    lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_a,null,false)
        Log.i("Debug", "onCreateView: FragmentA")
        return binding.root
    }
    override fun init() {
        Log.i("Debug", "loaded ")

    }

    override fun observe() {

    }

    override fun setListner() {
       binding.btnAdd.setOnClickListener {
           parentFragmentManager.beginTransaction()
               .replace(R.id.add_fragment,FragmentB.newInstance(),"")
               .addToBackStack("")
               .commit()
           Log.i("Debug", "setListner: add backstack Frag A ")
       }
    }

    override fun Load() {

    }


    override fun onResume() {
        super.onResume()
        Log.i("Debug", "onResume: FragmentA")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Debug", "onStop: FragmentA")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Debug", "onDestroy: FragmentA")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Debug", "onDestroyView:FragmentA ")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Debug", "onAttach:FragmentA ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Debug", "onDetach: FragmentA ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Debug", "onPause:FragmentA ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Debug", "onCreate: FragmentA")
    }



}