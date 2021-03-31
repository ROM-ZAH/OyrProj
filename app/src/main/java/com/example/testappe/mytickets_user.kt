package com.example.testappe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class mytickets_user : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mytickets_user)
        var spinner = findViewById<Spinner>(R.id.spinner1)
        val data = arrayOf("Активные", "Новые", "Выполненные", "Стратегические")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }
}