package com.example.androidtraining.mvvmRetrofit

import retrofit2.Call
import retrofit2.http.GET

//https://jsonplaceholder.typicode.com/posts



interface NetworkService {

    @GET("posts")
    fun getPost(): Call<List<Post>>
}

