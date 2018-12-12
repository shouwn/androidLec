package net.skhu.e01button

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_memo.*
import net.skhu.e01button.signup.SignupActivity

class MemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)

        btnSave.setOnClickListener {
            if(editText_title.text.isBlank())
                editText_title.error = "제목을 입력하세요"

            if(editText_content.text.isBlank())
                editText_content.error = "내용을 입력하세요"

            Toast.makeText(this@MemoActivity,
                    "저장 성공: ${editText_title.text}", Toast.LENGTH_LONG).show()

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
                else -> super.onOptionsItemSelected(item)
            }
}
