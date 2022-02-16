package com.example.androidtraining.message

import android.annotation.SuppressLint
import android.graphics.Insets.add
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.Insets.add
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseFragment
import com.example.androidtraining.databinding.FragmentListItemBinding
import com.example.androidtraining.databinding.FragmentMessageListBinding

class FragmentMessageList:BaseFragment() {
    companion object{
        fun newInstance():FragmentMessageList{
            val fragment = FragmentMessageList()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var adapter:Adapter
    lateinit var binding : FragmentMessageListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_message_list,null,false)
        return binding.root
    }
    override fun init() {
        setUpAdapter()
    }

    override fun observe() {

    }

    override fun setListner() {

    }

    override fun Load() {
        var item = ArrayList<MessageList>()
        item.add(MessageList("BMW","haoduong","hi","12:10",false))
        item.add(MessageList("Audi","khan","hi","12.11",true))
        Log.i("Debug", "item list initiated $item ")
        adapter.items = item
    }

    private fun setUpAdapter(){
        binding.messageListRv.apply {
            layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
            this@FragmentMessageList.adapter=Adapter(arrayListOf())
            adapter=this@FragmentMessageList.adapter
            val divider = DividerItemDecoration(context, RecyclerView.VERTICAL)
            divider.setDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.list_divider_empty, null
                )!!
            )
        }
    }
    inner class Adapter(var items:ArrayList<MessageList>)
        :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

        override fun getItemCount(): Int {
            return items.count()
        }
        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var item = items[position]
            holder as ItemHolder
            holder.binding.txtTitle.text= item.textTitle
            holder.binding.txtSenderGroupPersonal.text = item.sender
            holder.binding.lastText.text = item.lastMessage
            item.isRead.let {
                if (it){
                    holder.binding.isRead.visibility = View.GONE
                }
            }
        }



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val binding = DataBindingUtil.inflate<FragmentListItemBinding>(
                LayoutInflater.from(parent.context),R.layout.fragment_list_item,parent,false)
            return ItemHolder(binding)
        }

        inner class ItemHolder(val binding: FragmentListItemBinding)
            :RecyclerView.ViewHolder(binding.root)
    }

}

data class MessageList(
    val textTitle:String,
    val sender:String,
    val lastMessage:String,
    val dateTime:String,
    val isRead:Boolean
)


