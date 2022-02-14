package com.example.androidtraining.mvvmRetrofit

import com.example.androidtraining.AppApplication

class PostRepository (application: AppApplication,private val networkService: NetworkService){
    fun getPost() = networkService.getPost()
}