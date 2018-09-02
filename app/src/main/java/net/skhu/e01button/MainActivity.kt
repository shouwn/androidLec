package net.skhu.e01button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import net.skhu.e01button.R.styleable.View

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "내로그"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate 메소드 시작")

        this.findViewById<Button>(R.id.button).setOnClickListener {
            Log.d(TAG, "onClick 메소드 시작")
            val text1 = this.findViewById<EditText>(R.id.editText).text
            this.findViewById<EditText>(R.id.editText).text = this.findViewById<EditText>(R.id.editText2).text
            this.findViewById<EditText>(R.id.editText2).text = text1
            Log.d(TAG, "onClick 메소드 끝")
        }
        Log.d(TAG, "onCreate 메소드 끝")
    }
}
