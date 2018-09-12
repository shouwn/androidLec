package net.skhu.e01button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import net.skhu.e01button.R.styleable.View

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "내로그"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean =
        when(item?.itemId){
            R.id.action_signUp -> {
                Toast.makeText(this, "회원가입 메뉴 클릭", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_memo -> {
                Toast.makeText(this, "메모장 메뉴 클릭", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
