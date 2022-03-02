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
import com.example.androidtraining.databinding.FragmentBBinding

class FragmentB: BaseFragment() {
    companion object{
        fun newInstance(): FragmentB {
            val args = Bundle()
            val fragment = FragmentB()
            fragment.arguments = args
            return fragment
        }
    }

    lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_group,null,false)
        Log.i("Debug", "onCreateView: FragmentB")
        return binding.root

    }
    override fun init() {

    }

    override fun observe() {

    }

    override fun setListner() {
        binding.btnAdd.setOnClickListener {
            parentFragmentManager.popBackStack()
//                .beginTransaction()
//                .replace(R.id.add_fragment,FragmentC.newInstance(),"")
//                .addToBackStack("")
//                .commit()
            Log.i("Debug", "setListner: add backstack Frag C ")
        }
    }

    override fun Load() {
        (requireActivity() as Operations).passString("Hello this is Testing String")
        (requireActivity() as Operations).passInt(2)
    }


    override fun onResume() {
        super.onResume()
        Log.i("Debug", "onResume: FragmentB")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Debug", "onStop: FragmentB")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Debug", "onDestroy: FragmentB")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Debug", "onDestroyView:FragmentB ")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Debug", "onAttach:FragmentB ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Debug", "onDetach: FragmentB ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Debug", "onPause:FragmentB ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Debug", "onCreate: FragmentB")
    }
}