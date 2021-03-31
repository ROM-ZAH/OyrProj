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
import androidx.annotation.WorkerThread
import androidx.appcompat.app.AppCompatActivity
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import org.json.JSONObject


//"http://gpn.unmanned.ru/api/login"

//import com.example.testappe.R.layout.activity_log_in_user

private const val ENDPOINT = "https://gpn.unmanned.ru"
private const val LOG_IN_USER_URL = "/api/login"
private const val LOGIN = "login"
private const val PASSWORD = "password "


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
                        val token = jsonObject.get("token")
                        if (status == "success") {
                            startActivity(Intent(this, mytickets_user::class.java))
                        }
                    }
                   // Log.d("ok_http_test", "${res1.code.toString()}, ${res1.toString()},${res1.body?.string()}")
                }.start()

            }
        }

    }

    private fun POST(username :String, userPassword :String): Request
    {
        val jsonObject = JSONObject();

        jsonObject.put("login", username.toString());
        jsonObject.put("password", userPassword.toString());

        val client = OkHttpClient()
        val mediaType = "application/json; charset=utf-8".toMediaType()
        val body = jsonObject.toString().toRequestBody(mediaType)
        return Request.Builder()
                .url("https://gpn.unmanned.ru/api/login/")
                .post(body)
                .build()
    }
}
