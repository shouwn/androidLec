package net.skhu.e01button.recyclerView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_e05_list.*
import net.skhu.e01button.Item
import net.skhu.e01button.MyRecyclerViewAdapter
import net.skhu.e01button.R

class E05List : AppCompatActivity() {

    lateinit var myRecyclerViewAdapter: MyRecyclerViewAdapter
    lateinit var list: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_e4_list2)

        list = mutableListOf(Item("one"), Item("two"))

        myRecyclerViewAdapter = MyRecyclerViewAdapter(this, list)
        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this@E05List, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(this@E05List)
            itemAnimator = DefaultItemAnimator()
            adapter = myRecyclerViewAdapter
        }

        btnAdd.setOnClickListener {
            editText.also { text ->
                list.add(Item(text.text.toString()))
                myRecyclerViewAdapter.notifyDataSetChanged()
            }.apply {
                text.clear()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu) =
            menuInflater.inflate(R.menu.menu_main, menu)
                    .also {
                        menu.findItem(R.id.action_remove).isVisible =
                                myRecyclerViewAdapter.checkedItemCount > 0
                    }.let { true }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            if (item.itemId == R.id.action_remove)
                list.iterator().also {
                    while(it.hasNext())
                        if(it.next().checked) it.remove()

                }.let {
                    myRecyclerViewAdapter.notifyDataSetChanged()
                    true
                }
            else
                super.onOptionsItemSelected(item)
}
