package com.example.bijay.firebaseuseremialauthverifydemo.app

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import com.example.bijay.firebaseuseremialauthverifydemo.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var firebaseAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()
    }

    fun click(view: View) {

        when (view.id) {
            R.id.btnSignin -> {

                if(isValid()) {
                    progressBar.visibility = View.VISIBLE
                    val signinIntent = Intent(this@MainActivity, SigninActivity::class.java)
                    startActivity(signinIntent)
                    progressBar.visibility = View.GONE
                }
            }

            R.id.btnRegister -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(RegisterFragment(), "RegisterFragment")
                transaction.commit()
            }

            R.id.btnForgotPassword -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(ForgotPasswordFragment(), "ForgotPassworrdFragment")
                transaction.commit()
            }

            else -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(ResendEmailVerificationFragment(), "ResendEmailVerificationFragment")
                transaction.commit()
            }
        }
    }

    private fun isValid(): Boolean {
        if (etEmail.text.toString().isEmpty()) {
            etEmail.error = "Required"
            etEmail.requestFocus()
            return false
        } else if (TextUtils.isEmpty(etPassword.text)) {
            etPassword.error = "Required"
            etPassword.requestFocus()
            return false
        }

        return true;
    }

    private fun hideKeyboard() {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
