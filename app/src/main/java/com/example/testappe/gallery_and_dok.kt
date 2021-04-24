package com.example.testappe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class gallery_and_dok : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gallery_and_dok)
        val galleryyy = findViewById<Button>(R.id.button2)
        val documenttt = findViewById<Button>(R.id.doc)
        val back = findViewById<Button>(R.id.back_to_zayvki)
        galleryyy.setOnClickListener() {
            startActivity(Intent(this, gallery::class.java))
        }
        documenttt.setOnClickListener() {
            startActivity(Intent(this, document::class.java))
        }
        back.setOnClickListener() {
            startActivity(Intent(this, mytickets_user::class.java))
        }
    }
}