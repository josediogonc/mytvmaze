package com.example.mytvmaze.core.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.mytvmaze.R
import com.example.mytvmaze.core.extensions.supportFragmentManager
import com.example.mytvmaze.core.ui.dialog.DialogFactory

abstract class BaseFragment : Fragment() {

    open fun setupObservers() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupToolbar()
    }

    abstract fun setupToolbar()

    protected fun showDefaultErrorDialog() {
        DialogFactory.CustomDialog(
            title = getString(R.string.error_title_default),
            message = getString(R.string.error_message_default),
            buttonAction = { requireActivity().onBackPressed() }
        ).show(supportFragmentManager, "tag")
    }

}