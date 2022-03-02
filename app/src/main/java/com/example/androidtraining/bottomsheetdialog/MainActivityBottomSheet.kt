package com.example.androidtraining.bottomsheetdialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androidtraining.R
import com.example.androidtraining.databinding.MainActivityBottomSheetBinding
import com.siliconstack.training.adapter.demo_app.ui.dialog.ModelBottomSheet


class MainActivityBottomSheet:AppCompatActivity(){

    lateinit var binding: MainActivityBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity_bottom_sheet)
        setListener()
    }


     fun setListener() {
//        binding.dfBtn.setOnClickListener {
//            Log.i("dfbtn", "listner is on ")
//            TestDialogFragment.newInstance().show(supportFragmentManager,"")
//        }
//         binding.btmSheetBtn.setOnClickListener {
//             TestBottomSheetDialogFragment.newInstance(item).show(supportFragmentManager,"")
//         }
         binding.modelBottomSheet.setOnClickListener {
             ModelBottomSheet.newInstance().show(supportFragmentManager,"")
         }

         }

    }



