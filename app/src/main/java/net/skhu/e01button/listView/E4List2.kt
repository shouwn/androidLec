package net.skhu.e01button.listView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_e4_list2.*
import net.skhu.e01button.R

class E4List2 : AppCompatActivity() {

    private lateinit var myRecyclerViewAdapter: MyRecyclerViewAdapter
    private lateinit var list: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_e4_list2)

        list = mutableListOf("one", "two")

        myRecyclerViewAdapter = MyRecyclerViewAdapter(this, list)

        recyclerView.apply {
            addItemDecoration(
                    DividerItemDecoration(this@E4List2, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(this@E4List2)
            itemAnimator = DefaultItemAnimator()
            adapter = myRecyclerViewAdapter
        }

        btnAdd.setOnClickListener {
            list.add(editText.text.toString())
            editText.text.clear()
            myRecyclerViewAdapter.notifyDataSetChanged()

        }
    }
}
