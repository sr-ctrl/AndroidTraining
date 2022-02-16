package com.example.androidtraining.di


import com.example.androidtraining.mvvmRetrofit.NetworkService
import com.example.androidtraining.mvvmShopping.ShopService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
const val POST_BASE_URL = "https://jsonplaceholder.typicode.com/"
const val SHOP_BASE_URL = "https://fakestoreapi.com/"
val retrofitModule = module {

    fun getShopInstance() : ShopService {
        return Retrofit.Builder()
            .baseUrl(SHOP_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ShopService::class.java)
    }

    fun getPostInstance() : NetworkService {
        return Retrofit.Builder()
            .baseUrl(POST_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkService::class.java)
    }

    single { getShopInstance() }
    single { getPostInstance() }
}