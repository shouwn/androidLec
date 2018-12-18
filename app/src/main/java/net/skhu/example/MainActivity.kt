package net.skhu.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import net.skhu.example.firebase.recyclerView.MainActivity
import net.skhu.example.utils.startActivity

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
            R.id.action_list_view ->
                net.skhu.example.listView.MainActivity::class.startActivity(this)
            R.id.action_alert_dialog ->
                net.skhu.example.alertDialog.MainActivity::class.startActivity(this)
            R.id.action_spinner ->
                net.skhu.example.spinner.MainActivity::class.startActivity(this)
            R.id.action_checkbox ->
                net.skhu.example.checkbox.MainActivity::class.startActivity(this)
            R.id.action_sample ->
                net.skhu.example.firebase.sample.MainActivity::class.startActivity(this)
            else ->
                super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }
}
