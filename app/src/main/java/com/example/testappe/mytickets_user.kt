package com.example.testappe

import android.content.Intent
import android.graphics.Color.blue
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import okhttp3.OkHttpClient
import org.json.JSONObject


var id = ""
var surname = ""

class mytickets_user : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mytickets_user)
        var spinner = findViewById<Spinner>(R.id.spinner1)
        val data = arrayOf("Активные", "Новые", "Выполненные", "Стратегические")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data)
        val textView: TextView = findViewById<TextView>(R.id.ProfileName)
        val client = OkHttpClient()
        val filtrOpen = findViewById<Button>(R.id.button)
        val filtrClose = findViewById<Button>(R.id.button2)
        val user = intent.extras?.get("json")
        if (user == null) {
            Log.d("error", "-")
            return
        }
        Log.d("norm", "+")
        val jsonObject3 = JSONObject(user.toString())
        id = jsonObject3.get("id").toString()
        surname = jsonObject3.get("surname").toString()
        textView.text = "$surname $id"
        Log.d("ok_http_test_in_mytick", user.toString())
        filtrOpen.setOnClickListener() {
            startActivity(Intent(this, gallery_and_dok::class.java))
            //Showchekboks()
        }
        filtrClose.setOnClickListener() {
            Closechekboks()
        }

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }
    private fun Showchekboks()
    {
        val checkBox1  = findViewById<FrameLayout>(R.id.checkbox1 )
        val all_app = findViewById<FrameLayout>(R.id.all_app )
        checkBox1.visibility = View.VISIBLE
        all_app.alpha = 0.3F
    }
    private fun Closechekboks()
    {
        val checkBox1  = findViewById<FrameLayout>(R.id.checkbox1 )
        val all_app = findViewById<FrameLayout>(R.id.all_app )
        checkBox1.visibility = View.GONE
        all_app.alpha = 1F
   }
}