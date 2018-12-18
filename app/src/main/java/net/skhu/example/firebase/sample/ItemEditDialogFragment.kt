package net.skhu.example.firebase.sample

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.util.Log
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_checkbox.*
import net.skhu.example.R

class ItemEditDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val activity = (this.activity as MainActivity)
        val item = activity.itemList.getItem(activity.selectedIndex)

        val builder = AlertDialog.Builder(activity).apply {
            setTitle("수정")
        }

        val rootView = activity.layoutInflater.inflate(R.layout.item_with_time_image_edit, null)

        val editTextTitle = rootView.findViewById<EditText>(R.id.editText_title).apply {
            setText(item.title)
        }
        val editTextCreateDate = rootView.findViewById<EditText>(R.id.editText_createTime).apply {
            setText(item.getCreateTimeFormatted())
        }

        val radioGroup = rootView.findViewById<RadioGroup>(R.id.radioGroup).apply {
            check(when(item.iconIndex){
                0 -> R.id.radioCat
                1 -> R.id.radioDog
                2 -> R.id.radioOwl
                else -> R.id.radioCat
            })
        }

        return builder.setView(rootView)
                .setPositiveButton("저장") { _, _ ->
                    item.title = editTextTitle.text.toString()
                    item.setCreateTimeFormatted(editTextCreateDate.text.toString())
                    item.iconIndex = when(radioGroup.checkedRadioButtonId) {
                        R.id.radioCat -> 0
                        R.id.radioDog -> 1
                        R.id.radioOwl -> 2
                        else -> 0
                    }

                    activity.firebaseDbService.updateInServer(activity.selectedIndex)
                }
                .setNegativeButton("취소", null)
                .create()
    }
}