package com.example.androidtraining.di

import com.example.androidtraining.AppApplication
import com.example.androidtraining.mvvmRetrofit.NetworkService
import com.example.androidtraining.mvvmRetrofit.PostRepository
import com.example.androidtraining.mvvmShopping.ShopRepository
import com.example.androidtraining.mvvmShopping.ShopService
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val repositoryModule = module {
    fun injectShopRepository(api : ShopService, appApplication: AppApplication):ShopRepository{
        return ShopRepository(api,appApplication)
    }
    fun injectPostRepository(appApplication: AppApplication, api: NetworkService) : PostRepository{
        return PostRepository(appApplication,api)
    }

    single { injectShopRepository(get(),androidApplication() as AppApplication) }

    single { injectPostRepository(androidApplication() as AppApplication, get()) }
}