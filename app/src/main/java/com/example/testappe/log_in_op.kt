package com.example.testappe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.regex.Pattern


class log_in_op : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_op)


        val emailRegex = Pattern.compile(
                "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                        "\\@" +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                        "(" +
                        "\\." +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                        ")+"
        )
        findViewById<TextView>(R.id.passrestore).setOnClickListener()
        {
            //startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://nu-kak-tam-s-dengami.sk8er.name/")))
        }
        findViewById<Button>(R.id.log_in_op).setOnClickListener()
        {
            val username = findViewById<TextView>(R.id.user_mail_op).text
            val userPassword = findViewById<TextView>(R.id.user_pass_op).text
            if (!emailRegex.matcher(username).matches() || userPassword.isBlank())
            {
                val myToast = Toast.makeText(this, "Error:Incorrect field is empty", Toast.LENGTH_SHORT)
                myToast.show()
            }
            else
            {
                startActivity(Intent(this, mytickets_op::class.java))
            }
        }
    }
}