package net.skhu.example.firebase.recyclerView

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.widget.EditText
import net.skhu.example.R

class ItemEditDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle): Dialog {
        val activity = (this.activity as MainActivity)
        val item = activity.itemList.getItem(activity.selectedIndex)

        val builder = AlertDialog.Builder(activity).apply {
            setTitle("수정")
        }

        val rootView = activity.layoutInflater.inflate(R.layout.item_with_time_edit, null)

        val editTextTitle = rootView.findViewById<EditText>(R.id.editText_title)
        val editTextCreateDate = rootView.findViewById<EditText>(R.id.editText_createTime)

        editTextTitle.setText(item.title)
        editTextCreateDate.setText(item.getCreateTimeFormatted())

        return builder.setView(rootView)
                .setPositiveButton("저장") { _, _ ->
                    item.title = editTextTitle.text.toString()
                    item.setCreateTimeFormatted(editTextCreateDate.text.toString())

                    activity.firebaseDbService.updateInServer(activity.selectedIndex)
                }
                .setNegativeButton("취소", null)
                .create()
    }
}