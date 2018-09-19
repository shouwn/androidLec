package net.skhu.e01button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_memo.*

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
                    "저장 성공: ${editText_title.text}", Toast.LENGTH_LONG).show();

        }
    }
}
