package com.example.androidtraining.mvvmRetrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtraining.AppApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel ( appApplication: AppApplication, private val postRepository: PostRepository) :ViewModel() {

    val postList = MutableLiveData<List<Post>>()
    val error = MutableLiveData<String>()

    fun getPostList(){
        val response = postRepository.getPost()
        response.enqueue(object: Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                postList.postValue(response.body())
                Log.i("Debug", "response ${response.body()} ")
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                error.postValue(t.message)
                Log.i("Debug", "error ${t.message} ")
            }

        })
    }

}