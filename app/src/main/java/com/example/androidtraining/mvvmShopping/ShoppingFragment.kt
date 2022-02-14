package com.example.androidtraining.mvvmShopping

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseFragment
import com.example.androidtraining.databinding.FragmentShoppingBinding
import com.example.androidtraining.mvvmRetrofit.Post
import org.koin.android.ext.android.inject

class ShoppingFragment : BaseFragment(){

    companion object {
        fun newInstance():ShoppingFragment{
            val args = Bundle()
            val fragment = ShoppingFragment()
            fragment.arguments = args
            return fragment
        }
    }
    private val viewModel : ShoppingViewModel by inject()
    lateinit var binding:FragmentShoppingBinding
    private var shop: ArrayList<Shop> = ArrayList<Shop>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shopping,null,false)
        return binding.root
    }

    override fun init() {
        Log.i("Debug", "shopping fragment called ")
        //get viewmodel using viewmodel provider
//       val retrofitInstance = ShopService.getShopInstance()
//        viewModel = ViewModelProvider(this,ShopViewModelFactory(ShopRepository(retrofitInstance))).get(ShoppingViewModel::class.java)
        //using koin dependency injection
        viewModel.getShoppingItem()
    }

    override fun observe() {
        viewModel.shoppingList.observe(this,{
            Log.i("Debug", "observing the list $it ")

        })
    }

    override fun setListner() {

    }

    override fun Load() {

    }
}