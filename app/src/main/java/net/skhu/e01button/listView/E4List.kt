package net.skhu.e01button.listView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_e4_list.*
import net.skhu.e01button.R

class E4List : AppCompatActivity() {

    lateinit var list: MutableList<String>
    lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_e4_list)

        list = mutableListOf("One", "Two")

        adapter = ArrayAdapter(
                this@E4List,
                android.R.layout.simple_list_item_1,
                list)

        listView.adapter = adapter

        btnAdd.setOnClickListener {
            this.list.add(editText.text.toString())
                    .apply { editText.text.clear() }
            this.adapter.notifyDataSetChanged()
        }
    }
}
