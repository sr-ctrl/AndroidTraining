package com.example.androidtraining.mvvmRetrofit

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseFragment
import com.example.androidtraining.databinding.FragmentPostBinding
import org.koin.android.ext.android.inject

class FragmentPost : BaseFragment() {

    companion object{
        fun newInstance(): FragmentPost{
            val fragment = FragmentPost()
            val arg = Bundle()
            fragment.arguments = arg
            return fragment
        }
    }
    private val viewModel: PostViewModel by inject()
    lateinit var binding:FragmentPostBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_post,null, false)
        return binding.root
    }
    override fun init() {
//        val networkService = NetworkService.getRetrofitInstance()
//        postViewModel = ViewModelProvider(this,PostViewModelFactory(PostRepository(networkService))).get(PostViewModel::class.java)
        viewModel.getPostList()
        Log.i("Debug", "view model result ${viewModel.getPostList()} ")


    }

    override fun observe() {

    }

    override fun setListner() {

    }

    override fun Load() {

    }
}