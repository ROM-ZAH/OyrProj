package com.example.testappe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class mytickets_op : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mytickets_op)
        var spinner = findViewById<Spinner>(R.id.spinner1_op)
        val data = arrayOf("тут должнобыть что-то для оператора", "тут должнобыть что-то для оператора", "тут должнобыть что-то для оператора", "тут должнобыть что-то для оператора")
        /*
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        */
    }
}