package com.example.androidtraining.mvvmRetrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidtraining.AppApplication

//class PostViewModelFactory(appApplication:  AppApplication, private val repository: PostRepository): ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
//            PostViewModel(this.repository,appApplication = AppApplication()) as T
//        } else {
//            throw IllegalArgumentException("ViewModel Not Found")
//        }
//    }
//}