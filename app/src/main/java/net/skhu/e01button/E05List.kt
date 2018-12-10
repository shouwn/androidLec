package net.skhu.e01button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_e05_list.*

class E05List : AppCompatActivity() {

    lateinit var myRecyclerViewAdapter2: MyRecyclerViewAdapter2
    lateinit var list: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_e4_list2)

        list = mutableListOf(Item("one"), Item("two"))

        myRecyclerViewAdapter2 = MyRecyclerViewAdapter2(this, list)
        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this@E05List, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(this@E05List)
            itemAnimator = DefaultItemAnimator()
            adapter = myRecyclerViewAdapter2
        }

        btnAdd.setOnClickListener {
            editText.also { text ->
                list.add(Item(text.text.toString()))
                myRecyclerViewAdapter2.notifyDataSetChanged()
            }.apply {
                text.clear()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu) =
            menuInflater.inflate(R.menu.menu_main, menu)
                    .also {
                        menu.findItem(R.id.action_remove).isVisible =
                                myRecyclerViewAdapter2.checkedItemCount > 0
                    }.let { true }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            if (item.itemId == R.id.action_remove)
                list.iterator().also {
                    while(it.hasNext())
                        if(it.next().checked) it.remove()

                }.let {
                    myRecyclerViewAdapter2.notifyDataSetChanged()
                    true
                }
            else
                super.onOptionsItemSelected(item)
}
