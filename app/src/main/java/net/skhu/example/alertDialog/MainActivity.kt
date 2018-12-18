package net.skhu.example.alertDialog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alert_dialog.*
import net.skhu.example.R

class MainActivity : AppCompatActivity() {

    var selectedAnimationIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)

        button1.setOnClickListener {
            AlertDialog.Builder(this)
                    .setMessage(R.string.saveSuccess)
                    .setNeutralButton(R.string.close, null)
                    .create().show()
        }

        button2.setOnClickListener {
            AlertDialog.Builder(this)
                    .setTitle(R.string.confirm)
                    .setMessage(R.string.doYouWantToDelete)
                    .setPositiveButton(R.string.yes) { _, _ ->
                        Toast.makeText(this@MainActivity, "삭제성공", Toast.LENGTH_LONG).show()
                    }
                    .setNegativeButton(R.string.no, null)
                    .create().show()
        }

        button3.setOnClickListener {
            AlertDialog.Builder(this)
                    .setTitle(R.string.selectAnimal)
                    .setSingleChoiceItems(R.array.animals, selectedAnimationIndex, null)
                    .setPositiveButton(R.string.confirm) { dialog, _ ->
                        val listView = (dialog as AlertDialog).listView
                        selectedAnimationIndex = listView.checkedItemPosition
                        Toast.makeText(this@MainActivity,
                                "$selectedAnimationIndex 번째 항목이 선택되었습니다.",
                                Toast.LENGTH_SHORT).show()
                        val drawableId = when(selectedAnimationIndex) {
                            0 -> R.drawable.animal_cat_large
                            1 -> R.drawable.animal_dog_large
                            2 -> R.drawable.animal_owl_large
                            else -> 0
                        }

                        imageView1.setImageResource(drawableId)
                    }
                    .setNegativeButton(R.string.cancel, null)
                    .create().show()
        }
    }
}
