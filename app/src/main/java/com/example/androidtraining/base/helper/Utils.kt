package com.example.androidtraining.base.helper

import java.text.SimpleDateFormat
import java.util.*

class Utils {
    object DateUtils {
        fun getTime(): String {
            return SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
        }
        fun getTimeSeconds():String{
            return SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        }
    }
}