package com.siliconstack.training.adapter.demo_app.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.androidtraining.R
import com.example.androidtraining.databinding.ModelBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModelBottomSheet:BottomSheetDialogFragment() {

    companion object{
        fun newInstance():ModelBottomSheet{
            val fragment = ModelBottomSheet()
            val args = Bundle()
            fragment.arguments = args
            return fragment

        }
    }

    lateinit var binding: ModelBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.model_bottom_sheet,null,false)
        return binding.root
    }


}