package com.example.androidtraining.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtraining.R

import com.example.androidtraining.base.helper.Utils


private const val VIEW_TYPE_MY_MESSAGE = 1
    private const val VIEW_TYPE_OTHER_MESSAGE = 2

class MessageListAdapter(var messages: List<Data>) : RecyclerView.Adapter<MessageViewHolder>() {
//        private val messages: ArrayList<Message> = ArrayList()



        override fun getItemCount(): Int {
            return messages.size
        }

        override fun getItemViewType(position: Int): Int {
            val message = messages.get(position)

            return if(1 == message.viewType) {
                VIEW_TYPE_MY_MESSAGE
            }
            else {
                VIEW_TYPE_OTHER_MESSAGE
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
            return if(viewType == VIEW_TYPE_MY_MESSAGE) {
                MyMessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_outgoing_message, parent, false))
            } else {
                OtherMessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_incoming_message, parent, false))
            }
        }

        override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
            val message = messages.get(position)

            holder.bind(message)
        }

        inner class MyMessageViewHolder (view: View) : MessageViewHolder(view) {
            private var messageText: TextView = view.findViewById(R.id.outgoing_txt)
            private var timeText: TextView = view.findViewById(R.id.outgoing_txt_time)

            override fun bind(message: Data) {
                messageText.text = message.message
                message.dateAndTime = Utils.DateUtils.getTime()
                timeText.text = message.dateAndTime
            }
        }

        inner class OtherMessageViewHolder (view: View) : MessageViewHolder(view) {
            private var messageText: TextView = view.findViewById(R.id.incoming_txt)
            private var userText: TextView = view.findViewById(R.id.user_name)
            private var timeText: TextView = view.findViewById(R.id.incoming_txt_time)

            override fun bind(message: Data) {
                messageText.text = message.message
                userText.text = message.username
                message.dateAndTime = Utils.DateUtils.getTime()
                 timeText.text = message.dateAndTime
            }
        }
    }

    open class MessageViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        open fun bind(message: Data) {}
    }
