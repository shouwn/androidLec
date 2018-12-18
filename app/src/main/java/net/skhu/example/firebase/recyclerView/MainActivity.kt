package net.skhu.example.firebase.recyclerView

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_firebase_recycler_view.*
import net.skhu.example.R

class MainActivity : AppCompatActivity() {

    companion object {
        const val RC_SIGN_IN = 337
    }

    lateinit var myRecyclerViewAdapter: MyRecyclerViewAdapter
    lateinit var firebaseDbService: FirebaseDbService
    var itemEditDialogFragment: ItemEditDialogFragment? = null

    lateinit var itemList: ItemList<Item>
    var selectedIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_recycler_view)

        initRecyclerView()
    }

    private fun startLoginInActivity() {
        val providers = listOf(
                AuthUI.IdpConfig.EmailBuilder().build(),
                AuthUI.IdpConfig.GoogleBuilder().build())

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RC_SIGN_IN){
            val response = IdpResponse.fromResultIntent(data)
            val msg = when(resultCode){
                RESULT_OK -> "Authentication Success. ${FirebaseAuth.getInstance().currentUser?.displayName}"
                else -> "Authentication Failure. ${response?.error?.errorCode} ${response?.error?.message}"
            }

            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_LONG).show()
            invalidateOptionsMenu()
            initRecyclerView()
        }
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

        val user = FirebaseAuth.getInstance().currentUser
        val userId = user?.uid ?: "anonymous"

        this.firebaseDbService = FirebaseDbService(
                myRecyclerViewAdapter, itemList, userId)

        btnAdd.setOnClickListener {
            val title = editText.text.toString()
            editText.text.clear()
            firebaseDbService.addIntoServer(Item(title))
        }
    }

    fun showItemEditDialog(position: Int){
        if(itemEditDialogFragment == null) {
            Log.i("MainActivity", "itemEditDialogFragment is null")
            itemEditDialogFragment = ItemEditDialogFragment()
        }

        selectedIndex = position
        itemEditDialogFragment?.show(supportFragmentManager, "EditDialog")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        menu.findItem(R.id.action_remove).isVisible = itemList.getCount { it.checked } > 0
        val user = FirebaseAuth.getInstance().currentUser
        menu.findItem(R.id.action_logIn).isVisible = user == null
        menu.findItem(R.id.action_logOut).isVisible = user != null
        return true
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        val id = menuItem.itemId
        when(id){
            R.id.action_remove -> {
                itemList.filter { it.second.checked }
                        .map { it.first }
                        .forEach { firebaseDbService.removeFromServer(it) }
                menuItem.isVisible = false
                return true
            }
            R.id.action_logIn ->
                startLoginInActivity()
            R.id.action_logOut -> {
                FirebaseAuth.getInstance().signOut()
                invalidateOptionsMenu()
                initRecyclerView()
            }
        }
        return super.onOptionsItemSelected(menuItem)
    }
}
