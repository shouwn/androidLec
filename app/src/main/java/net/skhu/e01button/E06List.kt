package net.skhu.e01button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_e06_list.*

class E06List : AppCompatActivity() {

    var selectedIndex: Int = 0
    lateinit var recyclerViewAdapter: E06RecyclerViewAdapter
    lateinit var itemList: ItemList
    lateinit var firebaseDbService: FirebaseDbService
    var itemEditDialogFragment: ItemEditDialogFragment? = null

    companion object {
        const val RC_SIGN_IN = 337
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_e06_list)

        recyclerViewAdapter = E06RecyclerViewAdapter(this, itemList)

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
        this.itemList = ItemList()

        this.recyclerViewAdapter = E06RecyclerViewAdapter(this, itemList)
        val recyclerView = recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this@E06List, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(this@E06List)
            itemAnimator = DefaultItemAnimator()
            adapter = recyclerViewAdapter
        }

        var user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        val userId = user?.uid ?: "anonymous"
        this.firebaseDbService = FirebaseDbService(recyclerViewAdapter, itemList, userId)

        btnAdd.setOnClickListener {
            val title = editText.text.toString()
            editText.text.clear()
            firebaseDbService.addIntoServer(Item(title))
        }
    }

    fun showItemEditDialog(position: Int){
        if(this.itemEditDialogFragment == null)
            itemEditDialogFragment = ItemEditDialogFragment()

        this.selectedIndex = position
        itemEditDialogFragment!!.show(supportFragmentManager, "EditDialog")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        menu.findItem(R.id.action_remove).isVisible = itemList.getCheckedCount() > 0
        val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        menu.findItem(R.id.action_logIn).isVisible = user == null
        menu.findItem(R.id.action_logOut).isVisible = user != null
        return true
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        val id: Int = menuItem.itemId
        when (id){
            R.id.action_remove -> {
                for(i in itemList.size() downTo 0)
                    if (itemList.get(i).checked)
                        this.firebaseDbService.removeFromServer(itemList.getKey(i))
                menuItem.isVisible = false
                return true
            }
        }
    }
}
