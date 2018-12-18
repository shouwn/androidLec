package net.skhu.example.listView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view.*
import net.skhu.example.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val list = mutableListOf("One", "Two")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)

        listView.adapter = adapter

        btnAdd.setOnClickListener {
            val text = editText.text.toString()
            editText.text.clear()
            list.add(text).also {
                adapter.notifyDataSetChanged()
            }
        }
    }
}
