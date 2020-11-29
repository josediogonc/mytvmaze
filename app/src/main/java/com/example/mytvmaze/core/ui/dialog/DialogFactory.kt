package com.example.mytvmaze.core.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.example.mytvmaze.databinding.LayoutCustomDialogBinding

object DialogFactory {

    class CustomDialog(
        private val title: String,
        private val message: String,
        private val buttonMsg: String = "Ok",
        private val buttonAction: () -> Unit = { } ,
    ) : DialogFragment() {

        private lateinit var binding : LayoutCustomDialogBinding

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View {
            binding = LayoutCustomDialogBinding.inflate(inflater, container,false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupViews()
            setupClickListener()
        }

        override fun onStart() {
            super.onStart()
            setupDialogWindow()
        }

        private fun setupDialogWindow() {
            dialog?.window?.let {
                it.setLayout(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.WRAP_CONTENT
                )
                it.setBackgroundDrawableResource(android.R.color.transparent)
            }
        }

        private fun setupViews() {
            binding.apply {
                tvCustomDialogTitle.text = title
                tvCustomDialogMessage.text = message
                bt.text = buttonMsg
            }
        }

        private fun setupClickListener() {
            binding.bt.setOnClickListener {
                buttonAction.invoke()
                dismiss()
            }

        }
    }
}