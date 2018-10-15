package net.skhu.e01button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.R.layout.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_spinners.*


class SpinnersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinners)

        val stringArray = arrayOf("집주소", "직장주소", "기타")

        spinner_addressType.adapter = ArrayAdapter<String>(this, simple_spinner_item, stringArray)
                .apply { setDropDownViewResource(simple_spinner_dropdown_item) }

        btnSave.setOnClickListener {
            val spinner1 = spinner_phoneType

            val index1 = spinner1.selectedItemPosition
            val text1 = spinner1.selectedItem.toString()

            val spinner2 = spinner_addressType

            val index2 = spinner2.selectedItemPosition
            val text2 = spinner2.selectedItem.toString()

            Toast.makeText(this@SpinnersActivity,
                    "전화:$text1($index1) 주소:$text2($index2)",
                    Toast.LENGTH_SHORT).show()
        }

    }
}
