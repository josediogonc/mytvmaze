package com.example.mytvmaze.core.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mytvmaze.R
import com.example.mytvmaze.databinding.LayoutCustomDialogBinding
import kotlinx.android.synthetic.main.layout_custom_dialog.*
import kotlinx.android.synthetic.main.layout_custom_dialog.bt
import kotlinx.android.synthetic.main.layout_custom_dialog.tv_custom_dialog_message
import kotlinx.android.synthetic.main.layout_custom_dialog.tv_custom_dialog_title
import kotlinx.android.synthetic.main.layout_input_dialog.*

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

    class InputDialog(appContext: Context,
                      private val title: String,
                      private val message: String,
                      private val actionButtonMsg: String? = "Ok",
                      private val input: MutableLiveData<String>,
                      private val action: (() -> Unit)? = null,)
        : Dialog(appContext, R.style.CustomDialog) {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window?.setBackgroundDrawableResource(android.R.color.transparent)
            setContentView(R.layout.layout_input_dialog)
            setupViews()
            setupClickListener()
        }

        private fun setupClickListener() {
            bt.setOnClickListener {
                input.value = getInputValue()
                dismiss()
            }
        }

        private fun setupViews() {
            tv_custom_dialog_title.text = title
            tv_custom_dialog_message.text = message
            bt.text = actionButtonMsg
        }

        fun getInputValue() = et_input.text.toString()
    }

    open class CustomDialogWithOneButton(
        appContext: Context,
        private val title: String,
        private val message: String,
        private val actionButtonMsg: String? = "Ok",
        private val action: (() -> Unit)? = null,
        private val forceNonDismiss: Boolean = false
    ) : Dialog(appContext, R.style.CustomDialog) {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window?.setBackgroundDrawableResource(android.R.color.transparent)
            setContentView(R.layout.layout_custom_dialog)
            setupViews()
            setupClickListener()
            setupListener()
        }

        private fun setupViews() {
            tv_custom_dialog_title.text = title
            tv_custom_dialog_message.text = message
            bt.text = actionButtonMsg
        }

        private fun setupClickListener() {
            bt.setOnClickListener {
                if (forceNonDismiss)
                    action?.invoke()
                else
                    dismiss()
            }
        }

        private fun setupListener() {
            setOnDismissListener {
                action?.invoke()
            }
            setOnCancelListener {
                action?.invoke()
            }
        }
    }
}