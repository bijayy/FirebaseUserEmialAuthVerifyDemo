package com.example.bijay.firebaseuseremialauthverifydemo.app

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.bijay.firebaseuseremialauthverifydemo.R
import kotlinx.android.synthetic.main.fragment_change_email.*

/**
 *
 */
class ChangeEmailFragment : DialogFragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //dialog.setCanceledOnTouchOutside(false)
        return inflater.inflate(R.layout.fragment_change_email, container, false)
    }

    override fun onStart() {
        super.onStart()

        btnChangeEmail.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if(TextUtils.isEmpty(etChangeEmail.text)) {
            etChangeEmail.error = "Required"
            etChangeEmail.requestFocus()
        }
        else if(TextUtils.isEmpty(etPassword.text)) {
            etPassword.error = "Required"
            etPassword.requestFocus()
        }
        else {
            dismiss()
        }
    }
}
