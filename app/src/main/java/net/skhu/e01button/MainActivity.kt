package net.skhu.e01button

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "내로그"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val temp = editText.text
            editText.text = editText2.text
            editText2.text = temp
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean =
            menuInflater.inflate(R.menu.menu_main, menu).let { true }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean =
        when(item?.itemId){
            R.id.action_signUp -> {
                startActivity(Intent(this, SignupActivity::class.java))
                true
            }
            R.id.action_memo -> {
                startActivity(Intent(this, MemoActivity::class.java))
                true
            }
            R.id.action_buttons -> {
                startActivity(Intent(this, ButtonActivity::class.java))
                true
            }
            R.id.action_spinners -> {
                startActivity(Intent(this, SpinnersActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
