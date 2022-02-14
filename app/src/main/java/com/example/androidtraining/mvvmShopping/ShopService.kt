package com.example.androidtraining.mvvmShopping

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
//https://fakestoreapi.com/products?limit=10

interface ShopService {

    @GET("products")
    fun getShopItem() :Call<List<Shop>>

}