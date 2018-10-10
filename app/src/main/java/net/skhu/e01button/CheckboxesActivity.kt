package net.skhu.e01button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_checkboxes.*

class CheckboxesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkboxes)

        val listener1 = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            Toast.makeText(this@CheckboxesActivity,
                    "${buttonView.text} : $isChecked",
                    Toast.LENGTH_SHORT).show()
        }

        checkBox1.setOnCheckedChangeListener(listener1)
        switch1.setOnCheckedChangeListener(listener1)

        radioGroup1.setOnCheckedChangeListener { _, checkedId ->
            Toast.makeText(this@CheckboxesActivity,
                    findViewById<RadioButton>(checkedId).text,
                    Toast.LENGTH_SHORT).show()
        }

        radioGroup2.setOnCheckedChangeListener { _, checkedId ->
            imageView1.setImageResource(when (checkedId){
                radioCat.id -> R.mipmap.animal_cat_large
                radioDog.id -> R.mipmap.animal_dog_large
                radioOwl.id -> R.mipmap.animal_owl_large
                else -> 0
            })
        }


    }
}
