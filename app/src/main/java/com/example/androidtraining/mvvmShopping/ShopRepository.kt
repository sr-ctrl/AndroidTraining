package com.example.androidtraining.mvvmShopping

import com.example.androidtraining.AppApplication

class ShopRepository(private val service: ShopService, appApplication: AppApplication) {

    fun getShopItem() = service.getShopItem()
}