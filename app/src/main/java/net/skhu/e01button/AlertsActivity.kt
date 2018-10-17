package net.skhu.e01button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alerts.*

class AlertsActivity : AppCompatActivity() {

    private var selectedAnimalIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alerts)
    }

    fun button1_clicked(button: View){
        AlertDialog.Builder(this)
                .setMessage(R.string.saveSuccess)
                .setNeutralButton(R.string.close, null)
                .create()
                .show()
    }

    fun button2_clicked(button: View){
        AlertDialog.Builder(this)
                .setTitle(R.string.confirm)
                .setMessage(R.string.doYouWantToDelete)
                .setPositiveButton(R.string.yes) { _, _ ->
                    Toast.makeText(this@AlertsActivity, "삭제성공",
                            Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(R.string.no, null)
                .create()
                .show()
    }

    fun button3_clicked(button: View){
        AlertDialog.Builder(this)
                .setTitle(R.string.selectAnimal)
                .setSingleChoiceItems(R.array.animals, selectedAnimalIndex, null)
                .setPositiveButton(R.string.confirm) { dialog, _ ->
                    this.selectedAnimalIndex = (dialog as AlertDialog).listView.checkedItemPosition
                    Toast.makeText(this@AlertsActivity,
                            "$selectedAnimalIndex 번째 항목이 선택되었습니다.",
                            Toast.LENGTH_SHORT)
                            .show()

                    imageView1.setImageResource(when(selectedAnimalIndex){
                        0 -> R.drawable.animal_cat_large
                        1 -> R.drawable.animal_dog_large
                        2 -> R.drawable.animal_owl_large
                        else -> 0
                    })
                }
                .setNegativeButton(R.string.cancel, null)
                .create()
                .show()
    }
}
