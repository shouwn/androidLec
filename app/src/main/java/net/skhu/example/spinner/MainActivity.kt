package net.skhu.example.spinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_spinner.*
import net.skhu.example.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        val addressTypes = arrayOf("집주소", "직장주소", "기타")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, addressTypes).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        spinner_address_type.adapter = adapter

        btn_save.setOnClickListener {
            val index1 = spinner_phone_type.selectedItemPosition
            val text1 = spinner_phone_type.selectedItem.toString()

            val index2 = spinner_address_type.selectedItemPosition
            val text2 = spinner_address_type.selectedItem.toString()

            Toast.makeText(this@MainActivity,
                    "전화: $text1 ($index1)  주소: $text2 ($index2)",
                    Toast.LENGTH_SHORT).show()
        }
    }
}
