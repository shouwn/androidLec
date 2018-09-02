package net.skhu.e01button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import net.skhu.e01button.R.styleable.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.findViewById<Button>(R.id.button).setOnClickListener {
            val text1 = this.findViewById<EditText>(R.id.editText).text
            this.findViewById<EditText>(R.id.editText).text = this.findViewById<EditText>(R.id.editText2).text
            this.findViewById<EditText>(R.id.editText2).text = text1
        }
    }
}
