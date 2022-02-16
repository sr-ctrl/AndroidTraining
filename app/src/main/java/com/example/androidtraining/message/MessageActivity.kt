package com.example.androidtraining.message

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseActivity
import com.example.androidtraining.databinding.ActivityMessageBinding
import org.koin.android.ext.android.inject

class MessageActivity : BaseActivity() {

//    lateinit var messageViewModel:MessageViewModel
    private lateinit var recyclerViewAdapter: MessageListAdapter
    //get viemodel di
    private val viewModel:MessageViewModel by inject()
    lateinit var binding: ActivityMessageBinding
    var incomingMessage:String? = null
    var outgoingMessage:String? = null
    val dataList = ArrayList<Data>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_message)
        onCreatedViewDone()
    }


    override fun init() {
//        recyclerView = findViewById(R.id.messageList)
        //initialising viewmodel
//        viewModel = ViewModelProvider(this).get(MessageViewModel::class.java)
        supportFragmentManager.beginTransaction().replace(R.id.fragment__message_list_container,FragmentMessageDetails.newInstance(),"").commit()
//        supportFragmentManager.beginTransaction().replace(R.id.fragment__message_list_container,FragmentMessageList.newInstance(),"").commit()
    }

    override fun observe() {

    }

    override fun setListener() {


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