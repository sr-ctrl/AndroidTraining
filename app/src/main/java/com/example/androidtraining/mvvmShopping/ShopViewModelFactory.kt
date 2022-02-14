package com.example.androidtraining.mvvmShopping

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


//class ShopViewModelFactory(private val shopRepository: ShopRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return if (modelClass.isAssignableFrom(ShoppingViewModel::class.java)) {
//            ShoppingViewModel(this.shopRepository) as T
//        } else {
//            throw IllegalArgumentException("Shopping View Model Not Found")
//        }
//    }
//}

