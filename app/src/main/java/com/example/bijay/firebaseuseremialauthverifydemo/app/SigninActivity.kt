package com.example.bijay.firebaseuseremialauthverifydemo.app


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View

import com.example.bijay.firebaseuseremialauthverifydemo.R

class SigninActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = MenuInflater(this)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.change_email -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(ChangeEmailFragment(), "ChangeEmailFragment")
                transaction.commit()
                return true
            }
        }

        return false
    }
}
