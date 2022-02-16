package com.example.androidtraining.message

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseFragment
import com.example.androidtraining.databinding.FragmentMessageDetailsBinding
import org.koin.android.ext.android.inject

class FragmentMessageDetails : BaseFragment() {

    companion object{
        fun newInstance(): FragmentMessageDetails {
            val args = Bundle()
            val fragment = FragmentMessageDetails()
            fragment.arguments = args
            return  fragment
        }
    }

//    lateinit var messageViewModel:MessageViewModel
    private lateinit var recyclerViewAdapter: MessageListAdapter
    //get viemodel di
    private val viewModel:MessageViewModel by inject()
    lateinit var binding: FragmentMessageDetailsBinding
    var incomingMessage:String? = null
    var outgoingMessage:String? = null
    val dataList = ArrayList<Data>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_message_details,null,false)
        return binding.root
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

//        (requireActivity() as TestInterFace).fragmentMessageDetails()
//        Log.i("Debug", "${test.toString()}")
//        binding.day.text = test.toString()
    }

    override fun observe() {

        viewModel.messageListDataSend.observe(this, Observer {
            recyclerViewAdapter = MessageListAdapter((it))
            binding.messageList.layoutManager = LinearLayoutManager(requireContext())
            binding.messageList.adapter = recyclerViewAdapter
            recyclerViewAdapter.notifyDataSetChanged()
        })
    }

    override fun setListner() {
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


    override fun Load() {

    }

//
}