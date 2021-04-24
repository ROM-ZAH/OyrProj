package com.example.testappe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class gallery : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gallery)
        val back = findViewById<Button>(R.id.back_to_zayvki)
        back.setOnClickListener() {
            startActivity(Intent(this, gallery_and_dok::class.java))
        }
    }
}