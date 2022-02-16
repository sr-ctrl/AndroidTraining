package com.example.androidtraining

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidtraining.base.BaseActivity
import com.example.androidtraining.databinding.HomeActivityBinding
import com.example.androidtraining.message.Data
import com.example.androidtraining.message.MessageListAdapter
import com.example.androidtraining.message.MessageViewModel
import org.koin.android.ext.android.inject

class MessageActivity : BaseActivity() {

//    lateinit var messageViewModel:MessageViewModel
    private lateinit var recyclerViewAdapter: MessageListAdapter
    //get viemodel di
    private val viewModel:MessageViewModel by inject()
    lateinit var binding: HomeActivityBinding
    var incomingMessage:String? = null
    var outgoingMessage:String? = null
    val dataList = ArrayList<Data>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.home_activity)
        onCreatedViewDone()
    }


    override fun init() {
//        dataList.add(Data(1, "khan", "1.  1. Hi! I am in View 1 1. Hi! I am in View 1 1. Hi! I am in View 1 1. Hi! I am in View 1 1. Hi! I am in View 1Hi! I am in View 1", "12.00"))
//        dataList.add(Data(2, "shahrukh", "1. Hi . Hi! I am in View 1 . Hi! I am in View 1 . Hi! I am in View 1 v! I am in View 1", "12.00"))
//        dataList.add(Data(1, "khan", "1. Hi! I am in View 1", "12.00"))
//        dataList.add(Data(2, "shahrukh", "1 . Hi! I am in View 1 . Hi! I am in View 1 . Hi! I am in View 1. Hi! I am in View 1", "12.00"))
//        dataList.add(Data(1, "khan", "1. Hi! I am in View 1", "12.00"))
//        dataList.add(Data(1, "khan", "1.  1. Hi! I am in View 1 1. Hi! I am in View 1 1. Hi! I am in View 1 1. Hi! I am in View 1 1. Hi! I am in View 1Hi! I am in View 1", "12.00"))
//        dataList.add(Data(2, "shahrukh", "1. Hi . Hi! I am in View 1 . Hi! I am in View 1 . Hi! I am in View 1 v! I am in View 1", "12.00"))
//        dataList.add(Data(1, "khan", "1. Hi! I am in View 1", "12.00"))
//        dataList.add(Data(2, "shahrukh", "1 . Hi! I am in View 1 . Hi! I am in View 1 . Hi! I am in View 1. Hi! I am in View 1", "12.00"))
//        dataList.add(Data(1, "khan", "1. Hi! I am in View 1", "12.00"))
//        dataList.add(Data(1, "khan", "1.  1. Hi! I am in View 1 1. Hi! I am in View 1 1. Hi! I am in View 1 1. Hi! I am in View 1 1. Hi! I am in View 1Hi! I am in View 1", "12.00"))
//        dataList.add(Data(2, "shahrukh", "1. Hi . Hi! I am in View 1 . Hi! I am in View 1 . Hi! I am in View 1 v! I am in View 1", "12.00"))
//        dataList.add(Data(1, "khan", "1. Hi! I am in View 1", "12.00"))
//        dataList.add(Data(2, "shahrukh", "1 . Hi! I am in View 1 . Hi! I am in View 1 . Hi! I am in View 1. Hi! I am in View 1", "12.00"))
//        dataList.add(Data(1, "khan", "1. Hi! I am in View 1", "12.00"))
//        dataList.add(Data(1, "khan", "1.  1. Hi! I am in View 1 1. Hi! I am in View 1 1. Hi! I am in View 1 1. Hi! I am in View 1 1. Hi! I am in View 1Hi! I am in View 1", "12.00"))
//        dataList.add(Data(2, "shahrukh", "1. Hi . Hi! I am in View 1 . Hi! I am in View 1 . Hi! I am in View 1 v! I am in View 1", "12.00"))
//        dataList.add(Data(1, "khan", "1. Hi! I am in View 1", "12.00"))
//        dataList.add(Data(2, "shahrukh", "1 . Hi! I am in View 1 . Hi! I am in View 1 . Hi! I am in View 1. Hi! I am in View 1", "12.00"))
//        dataList.add(Data(1, "khan", "1. Hi! I am in View 1", "12.00"))


//        recyclerView = findViewById(R.id.messageList)
        //initialising viewmodel
//        viewModel = ViewModelProvider(this).get(MessageViewModel::class.java)


    }

    override fun observe() {

        viewModel.messageListDataSend.observe(this, Observer {
            recyclerViewAdapter = MessageListAdapter((it))
            binding.messageList.layoutManager = LinearLayoutManager(this)
            binding.messageList.adapter = recyclerViewAdapter
            recyclerViewAdapter.notifyDataSetChanged()
        })
    }

    override fun setListener() {

        binding.iconAttach.setOnClickListener {
            Log.i("Debug", "setListener: ${incomingMessage.toString()} ")
            incomingMessage = binding.inputMessage.text.toString()
            if (incomingMessage!!.isNotEmpty()){
                viewModel.list.add(Data(2,"khan",incomingMessage!!,""))
                viewModel.addSendMessage()
                binding.inputMessage.editableText.clear()
//            addSendMessage(incomingMessage)
            }


        }
        binding.btnSend.setOnClickListener {
            outgoingMessage = binding.inputMessage.text.toString()
//            messageViewModel.addReciverMessage(outgoingMessage!!).toString()
//            addReceiverMessage(outgoingMessage)
            if(outgoingMessage!!.isNotEmpty()){
                viewModel.list.add(Data(1,null,outgoingMessage!!,""))
                viewModel.addReceiverMessage()
                binding.inputMessage.editableText.clear()
            }

        }
    }

    override fun load() {

    }

//    private fun addSendMessage(message:String){
//        dataList.add(Data(viewType=2,username = "khan",message,dateAndTime = "12.12"))
//    }
//    private fun addReceiverMessage(message:String){
//        dataList.add(Data(viewType = 1,username ="shahrukh",message,dateAndTime = "12.34" ))
//    }
}