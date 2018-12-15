package net.skhu.example.firebase.recyclerView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_firebase_recycler_view.*
import net.skhu.example.R

class MainActivity : AppCompatActivity() {

    companion object {
        const val RC_SIGN_IN = 337
    }

    lateinit var myRecyclerViewAdapter: MyRecyclerViewAdapter
    lateinit var firebaseDbService: FirebaseDbService
    lateinit var itemEditDialogFragment: ItemEditDialogFragment

    lateinit var itemList: ItemList
    var selectedIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_recycler_view)


    }

    private fun initRecyclerView() {
        this.itemList = ItemList()
        this.myRecyclerViewAdapter = MyRecyclerViewAdapter(this, itemList)

        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(this@MainActivity)
            itemAnimator = DefaultItemAnimator()
            adapter = myRecyclerViewAdapter
        }
    }
}
