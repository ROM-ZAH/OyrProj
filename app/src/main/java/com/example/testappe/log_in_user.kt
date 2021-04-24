package com.example.testappe


import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import org.json.JSONObject


//"http://gpn.unmanned.ru/api/login"

//import com.example.testappe.R.layout.activity_log_in_user

var TOKEN = ""

class log_in_user : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?)   {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_user)
        findViewById<TextView>(R.id.passrestore).setOnClickListener()
        {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://nu-kak-tam-s-dengami.sk8er.name/")))
        }
        findViewById<Button>(R.id.log_in_user).setOnClickListener()
        {
            val username = findViewById<TextView>(R.id.user_mail_user).text
            val userPassword = findViewById<TextView>(R.id.user_pass_user).text
            if (userPassword.isBlank())
            {
                val myToast = Toast.makeText(this, "Error:Incorrect field is empty", Toast.LENGTH_SHORT)
                myToast.show()
            }
            else
            {
                val client = OkHttpClient()
                val request = POST(username.toString(), userPassword.toString())

                Thread {
                    val res1 = client.newCall(request).execute()
                    val jsonObject = JSONObject(res1.body?.string())

                    val code = res1.code.toString()
                    if (code != "500") {
                        val status = jsonObject.get("status")
                        TOKEN = jsonObject.get("token").toString()
                        Log.d("ok_http_test", code)
                        if (status == "success") {
                            val newIntent = Intent(this, mytickets_user::class.java)

                            val request2 = GET(TOKEN)

                            val res2 = client.newCall(request2).execute()
                            val jsonObject2 = JSONObject(res2.body?.string())
                            val user = jsonObject2.get("user").toString()
                            newIntent.putExtra("json", user)
                            startActivity(newIntent)
                        }
                    }
                   // Log.d("ok_http_test", "${res1.code.toString()}, ${res1.toString()},${res1.body?.string()}")
                }.start()

            }
        }

    }
}
