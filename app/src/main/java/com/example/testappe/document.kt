package com.example.testappe

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.concurrent.thread
import kotlin.random.Random


class document : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.document)

        val adapter = RecyclerViewAdapter()


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val buttton = findViewById<Button>(R.id.button3)
        val butttonn = findViewById<Button>(R.id.button4)
        buttton.setOnClickListener {
            adapter.addItem(String(Random.nextBytes(16)))
        }

        butttonn.setOnClickListener {
            thread {
                listOf("asdaf", "asdwertet", "asdwfer").forEach { string ->
                    runOnUiThread{adapter.addItem(string)}
                    }
                }
            }
        }

    }


class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewViewHolder>() {

    private val items = ArrayList<String>()

    fun addItem(string: String) {
        items.add(string)
        notifyItemInserted(items.lastIndex)
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return RecyclerViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        holder.textView.text = items[position]

        holder.itemView.setOnClickListener {
            removeItem(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class RecyclerViewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView = view.findViewById(R.id.text_item)
}