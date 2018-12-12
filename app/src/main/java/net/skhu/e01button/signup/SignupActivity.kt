package net.skhu.e01button.signup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*
import net.skhu.e01button.R.layout.activity_signup


class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_signup)

        button2.setOnClickListener {
            val loginId = editText_loginId
            val password = editText_password
            val password2 = editText_password2
            val email = editText_email

            if (loginId.text.isBlank())
                loginId.error = "로그인 아이디를 입력하세요"

            if (password.text.isBlank())
                password.error = "비밀번호를 입력하세요"

            if (password.text != password2.text)
                password2.error = "비밀번호가 일치하지 않습니다"

            // 회원 가입 데이터를 서버에 전송하는 코드를 구현해야 함.

            val msg = "회원가입 성공: ${loginId.text} ${email.text}"
            Toast.makeText(this@SignupActivity, msg, Toast.LENGTH_LONG).show()
        }
    }
}
