package net.skhu.e01button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_signup.*
import java.util.function.Supplier


class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        button2.setOnClickListener {
            if (editText_loginId.text.isBlank())
                editText_loginId.error = "로그인 아이디를 입력하세요"

            if (editText_password.text.isBlank())
                editText_password.error = "비밀번호를 입력하세요"

            if (editText_password.text != editText_password2.text)
                editText_password2.error = "비밀번호가 일치하지 않습니다"

            // 회원 가입 데이터를 서버에 전송하는 코드를 구현해야 함.
            val msg = "회원가입 성공: ${editText_loginId.text} ${editText_email.text}"
            Toast.makeText(this@SignupActivity, msg, Toast.LENGTH_LONG).show()
        }
    }
}
