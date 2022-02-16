package com.example.androidtraining.mvvmShopping

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtraining.AppApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShoppingViewModel(application: AppApplication, private val repository: ShopRepository) :ViewModel() {

    val shoppingList = MutableLiveData<List<Shop>>()
    val error = MutableLiveData<String>()
    val error2 = MutableLiveData<String>()
    val error3 = MutableLiveData<String>()


    fun getShoppingItem(){
        val result = repository.getShopItem()
        result.enqueue(object : Callback<List<Shop>> {
            override fun onResponse(call: Call<List<Shop>>, response: Response<List<Shop>>) {
                shoppingList.value = response.body()
                Log.i("Debug", "onResponse: api called ")
            }

            override fun onFailure(call: Call<List<Shop>>, t: Throwable) {
                Log.i("Debug", "onFailure: ${t.message} ")
                Log.i("Debug", "onFailure:${(t.message)} ")
                Log.i("Debug", "onFailure:${(t.localizedMessage)}")
                Log.i("Debug", "onFailure:${(t.cause.toString())} ")
            }

        })
    }
}