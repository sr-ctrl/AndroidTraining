package com.example.androidtraining.di


import com.example.androidtraining.AppApplication
import com.example.androidtraining.message.MessageViewModel
import com.example.androidtraining.mvvmRetrofit.PostViewModel
import com.example.androidtraining.mvvmShopping.ShoppingViewModel
import com.example.androidtraining.utils.TextWatcherViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ShoppingViewModel(androidApplication() as AppApplication, get())
    }

    viewModel {
        PostViewModel(androidApplication() as AppApplication, get())
    }
    viewModel {
        TextWatcherViewModel(androidApplication() as AppApplication)
    }
    viewModel {
        MessageViewModel(androidApplication() as AppApplication)
    }
}