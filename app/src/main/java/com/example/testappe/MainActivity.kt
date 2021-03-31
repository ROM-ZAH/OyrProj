package com.example.testappe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.view.View
import android.widget.ProgressBar

import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CloseBare()
        val loginop = findViewById<Button>(R.id.op_login)
        loginop.setOnClickListener() {
            val log_in_start = Intent(this, log_in_op::class.java)
            ShowBare()
            val startTime = System.currentTimeMillis()
            //while (System.currentTimeMillis() - startTime < 10000)

            startActivity(log_in_start)
        }
        val loginuser = findViewById<Button>(R.id.user_login)
        loginuser.setOnClickListener() {
            val log_in_start = Intent(this, log_in_user::class.java)
            ShowBare()
            val startTime = System.currentTimeMillis()
            //while (System.currentTimeMillis() - startTime < 10000)

            startActivity(log_in_start)
        }
    }

    private fun ShowBare()
    {
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
    }
    private fun CloseBare()
    {
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.GONE
    }

}