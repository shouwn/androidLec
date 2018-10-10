package net.skhu.e01button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_button.*

class ButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        val listener = View.OnClickListener {
            val msg = when(it.id){
                button3.id -> "첫 번쨰 버튼이 클릭 되었습니다."
                button4.id -> "두 번째 버튼이 클릭 되었습니다."
                button5.id -> "세 번째 버튼이 클릭 되었습니다."
                imageButton1.id -> "첫 번째 이미지 버튼이 클릭 되었습니다."
                imageButton2.id -> "두 번째 이미지 버튼이 클릭 되었습니다."
                imageButton3.id -> "세 번째 이미지 버튼이 클릭 되었습니다."
                imageButton4.id -> "네 번째 이미지 버튼이 클릭 되었습니다."
                else -> "알 수 없는 버튼이 클릭 되었습니다"
            }

            Toast.makeText(this@ButtonActivity, msg, Toast.LENGTH_SHORT).show()
        }

        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)

        imageButton1.setOnClickListener(listener)
        imageButton2.setOnClickListener(listener)
        imageButton3.setOnClickListener(listener)
        imageButton4.setOnClickListener(listener)
    }
}
