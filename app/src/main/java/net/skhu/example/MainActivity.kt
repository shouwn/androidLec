package net.skhu.example

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import net.skhu.example.firebase.recyclerView.MainActivity
import net.skhu.example.firebase.utils.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_door, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_firebase_with_recyclerView ->
                MainActivity::class.startActivity(this)
            R.id.action_firebase_log_in ->
                net.skhu.example.firebase.logIn.MainActivity::class.startActivity(this)
            else ->
                super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }
}
