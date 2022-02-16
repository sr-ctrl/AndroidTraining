package com.example.androidtraining.mvvmShopping

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.GridLayout
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseFragment
import com.example.androidtraining.databinding.FragmentListItemBinding
import com.example.androidtraining.databinding.FragmentShoppingBinding
import com.example.androidtraining.databinding.ShoppingItemBinding
import com.example.androidtraining.mvvmRetrofit.Post
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory
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
    private lateinit var adapter: Adapter
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
        setUpAdapter()
    }

    override fun observe() {
        viewModel.shoppingList.observe(this,{
            Log.i("Debug", "observing the list $it ")
            adapter.items = it as ArrayList<Shop>
            adapter.notifyDataSetChanged()
            Log.i("Debug", "observe:$it ")

        })
    }

    override fun setListner() {

    }

    override fun Load() {
        viewModel.error.observe(this,{
//            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            Log.i("Debug", "Load:$it ")
        })
        viewModel.error2.observe(this,{
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            Log.i("Debug", "Load:$it ")
        })
        viewModel.error3.observe(this,{
//            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            Log.i("Debug", "Load:$it ")
        })

    }

    private fun setUpAdapter(){
        binding.ShoppingRv.apply {
            layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
            this@ShoppingFragment.adapter = Adapter(arrayListOf())
            adapter = this@ShoppingFragment.adapter
            val divider = DividerItemDecoration(context, RecyclerView.VERTICAL)
            divider.setDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.list_divider_empty, null
                )!!
            )
        }
    }

    inner class Adapter(var items:ArrayList<Shop>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

        override fun getItemCount(): Int {
            return items.count()
        }
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val item = items[position]
            holder as ItemHolder
            holder.binding.itemTitle.text = item.category
            holder.binding.itemCategory.text = item.title
            holder.binding.price.text = "Price:${item.price}"
            holder.binding.count.text = "Count:${item.rating.count}"
            holder.binding.rate.text = "Rating:${item.rating.rate}"
            item.image.let {
                Glide.with(requireActivity())
                    .load(it)
                    .into(holder.binding.itemImage)
            }
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val binding = DataBindingUtil.inflate<ShoppingItemBinding>(
                LayoutInflater.from(parent.context),R.layout.shopping_item,parent,false)
            return ItemHolder(binding)
        }

        inner class ItemHolder(val binding:ShoppingItemBinding):RecyclerView.ViewHolder(binding.root)

    }
}