package net.skhu.e01button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_e06_list.*

class E06List : AppCompatActivity() {

    var selectedIndex: Int = 0
    lateinit var recyclerViewAdapter: E06RecyclerViewAdapter
    lateinit var list: ItemList

    companion object {
        const val RC_SIGN_IN = 337
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_e06_list)

        recyclerViewAdapter = E06RecyclerViewAdapter(this, list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            addItemDecoration(DividerItemDecoration(this@E06List, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(this@E06List)
            itemAnimator = DefaultItemAnimator()
            adapter = recyclerViewAdapter
        }

        btnAdd.setOnClickListener {

        }
    }

    private fun initRecyclerView() {
        this.list = ItemList()


    }
}
