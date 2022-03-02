package com.example.androidtraining.bottomsheetdialog

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseBottomSheetDialog
import com.example.androidtraining.databinding.BottomSheetItemBinding
import com.example.androidtraining.databinding.TestBtmSheetDialFragmentBinding
import com.example.androidtraining.mvvmRetrofit.Post
import com.example.androidtraining.mvvmRetrofit.PostViewModel
import com.example.androidtraining.mvvmShopping.Shop
import com.example.androidtraining.mvvmShopping.ShoppingViewModel
import org.koin.android.ext.android.inject

class TestBottomSheetDialogFragment: BaseBottomSheetDialog() {

    val TAG = TestBottomSheetDialogFragment::class.java.name

    companion object {
        fun  newInstance(postList: List<Post>?): TestBottomSheetDialogFragment {
            val fragment = TestBottomSheetDialogFragment()
            val args = Bundle()
            args.putParcelableArrayList("item",postList as? java.util.ArrayList<out Parcelable>)
            fragment.arguments = args
            return fragment
        }
    }
//    private val viewModel: ShoppingViewModel by inject()
    private val viewModel:PostViewModel by inject()
    lateinit var adapter: Adapter
    private var titleList : List<Post>? = null
    lateinit var binding: TestBtmSheetDialFragmentBinding
    private val items by  lazy {
        arguments?.getParcelableArrayList<Parcelable>("item") as? List<Post>
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.test_btm_sheet_dial_fragment,null,false)
        val args = arguments
        val test = args!!.getString("test")
        Log.d(TAG, "onCreateView: test : $test")
        return binding.root
    }
    override fun init() {

    }

    override fun observe() {
        Log.i("Debug", "observeing the recieved items $items ")

    }

    override fun setListener() {
//        binding.btnSubmit.setOnClickListener { dismiss() }


    }

    override fun load() {
//        val item = arrayListOf<Bottom>(
//            Bottom("Hello"),
//        Bottom("sample Text"),
//        Bottom("Dummy TExt")
//        )
        viewModel.postList.observe(this, androidx.lifecycle.Observer {

            it.map {
                Log.i("Debug", "shopping list title ")
                Log.i("Debug", "${it.title} ")
//                titleList = it
            }
        })

        binding.btmSheetRcv.apply {
            layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
            this@TestBottomSheetDialogFragment.adapter = Adapter(arrayListOf())
            adapter = this@TestBottomSheetDialogFragment.adapter
            val divider = DividerItemDecoration(context, RecyclerView.VERTICAL)
            divider.setDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.list_divider_empty, null
                )!!
            )
        }
        adapter.items = items!!
        adapter.notifyDataSetChanged()
        }


    inner class Adapter(var items:List<Post>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

        override fun getItemCount(): Int {
            return items.count()
        }
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val item = items[position]
            holder as ItemHolder
            holder.binding.btmText.text = item.title
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val binding = DataBindingUtil.inflate<BottomSheetItemBinding>(
                LayoutInflater.from(parent.context),R.layout.bottom_sheet_item,parent,false)
            return ItemHolder(binding)
        }

        inner class ItemHolder(val binding: BottomSheetItemBinding): RecyclerView.ViewHolder(binding.root)

    }
}

class Bottom (
    val TestBtmString:String
        )
