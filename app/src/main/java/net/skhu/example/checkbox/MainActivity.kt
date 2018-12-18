package net.skhu.example.checkbox

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_checkbox.*
import net.skhu.example.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)

        val listener1 =
                CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                    Toast.makeText(this@MainActivity,
                            "${buttonView.text} : $isChecked",
                            Toast.LENGTH_SHORT)
                }

        checkBox1.setOnCheckedChangeListener(listener1)
        switch1.setOnCheckedChangeListener(listener1)

        val listener2 =
                RadioGroup.OnCheckedChangeListener { _, checkedId ->
                    val radioButton = findViewById<RadioButton>(checkedId)
                    Toast.makeText(this@MainActivity, radioButton.text.toString(), Toast.LENGTH_SHORT).show()
                }

        radioGroup1.setOnCheckedChangeListener(listener2)

        val listener3 =
                RadioGroup.OnCheckedChangeListener { _, checkedId ->
                    val drawableId = when(checkedId) {
                        R.id.radioCat -> R.drawable.animal_cat_large
                        R.id.radioDog -> R.drawable.animal_dog_large
                        R.id.radioOwl -> R.drawable.animal_owl_large
                        else -> 0
                    }
                    iconView.setImageResource(drawableId)
                }

        radioGroup.setOnCheckedChangeListener(listener3)

        btnSave.setOnClickListener {
            val radioGroup1Text = when(radioGroup1.checkedRadioButtonId){
                R.id.radioRed -> "red"
                R.id.radioBlue -> "blue"
                R.id.radioYellow -> "yellow"
                else -> ""
            }

            val radioGroup2Text = when(radioGroup.checkedRadioButtonId){
                R.id.radioCat -> "cat"
                R.id.radioDog -> "dog"
                R.id.radioOwl -> "owl"
                else -> ""
            }

            val s = """
                |checkBox1=${checkBox1.isChecked}
                |switch1=${switch1.isChecked}
                |radioGroup1=$radioGroup1Text
                |radioGroup2=$radioGroup2Text
                |""".trimMargin()

            Toast.makeText(this@MainActivity, s, Toast.LENGTH_SHORT).show()
        }
    }
}
