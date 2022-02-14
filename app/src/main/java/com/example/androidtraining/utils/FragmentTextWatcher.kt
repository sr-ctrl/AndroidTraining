package com.example.androidtraining.utils

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseFragment
import com.example.androidtraining.base.helper.Utils

import com.example.androidtraining.databinding.FragmentTextWatcherBinding
import com.example.androidtraining.mvvmRetrofit.FragmentPost
import com.example.androidtraining.mvvmShopping.ShoppingFragment
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject


class FragmentTextWatcher:BaseFragment(){
    companion object{
        fun newInstance(): FragmentTextWatcher {
            val args = Bundle()
            val fragment = FragmentTextWatcher()
            fragment.arguments = args
            return fragment
        }
    }
    lateinit var binding:FragmentTextWatcherBinding
//    lateinit var textWatcherViewModel:TextWatcherViewModel
    private val viewModel:TextWatcherViewModel by inject()
    lateinit var enteredText:String
    private var job: Job? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_text_watcher,null,false)
        return binding.root
    }

    override fun init() {
//        textWatcherViewModel = ViewModelProvider(this).get(TextWatcherViewModel::class.java)
    }

    override fun observe() {
//        val text = binding.enterText.text
//        Log.i("Debug", "observe: entered text is $text ")
        binding.enterText.addTextChangedListener(textWatcher)
    }

    override fun setListner() {
        binding.getTime.setOnClickListener {
            binding.time.text = Utils.DateUtils.getTimeSeconds()
        }
        binding.datePickerIcon.setOnClickListener {
            //todos
        }

        binding.mvvmRetrofit.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container,
                FragmentPost.newInstance(),"").commit()
            goNext()
        }

        binding.shopping.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container,ShoppingFragment.newInstance(),"").commit()
            goNext()
        }


    }

    override fun Load() {
        //to delay the function call
//        Handler().postDelayed({
//            binding.time.text = Utilities.DateUtils.getTimeSeconds()
//        }, 1000)
        }


    private var textWatcher = object : TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            Log.i("Debug", "text change is called ")
            enteredText = binding.enterText.text.toString()
            viewModel.enteredTextFun(enteredText)
            Log.i("Debug", "text on change is ${viewModel.textWatcherText.value} ")
            binding.outputTextWatcher.text = viewModel.textWatcherText.value
        }
        override fun afterTextChanged(p0: Editable?) {
        }
    }
}


//fun startUpdates() {
//    job = scope.launch {
//        while(true) {
//            getData() // the function that should be ran every second
//            delay(1000)
//        }
//    }
//}