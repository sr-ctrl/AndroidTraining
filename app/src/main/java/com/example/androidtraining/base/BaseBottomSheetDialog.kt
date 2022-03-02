package com.example.androidtraining.base

import android.app.Dialog
import android.os.Bundle
import android.view.View
import com.example.androidtraining.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetDialog : BottomSheetDialogFragment() {



        protected abstract fun init()
        protected abstract fun observe()
        protected abstract fun setListener()
        protected abstract fun load()


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            init()
            observe()
            setListener()
            load()
        }

    }
