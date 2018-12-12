package net.skhu.e01button

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView

class MyRecyclerViewAdapter(
        context: Context,
        val list: List<Item>
) : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), CompoundButton.OnCheckedChangeListener {

        var textView1: TextView = view.findViewById(R.id.textView1)
        var textView2: TextView = view.findViewById(R.id.textView2)
        var checkBox: CheckBox = view.findViewById(R.id.checkBox)

        init {
            this.checkBox.setOnCheckedChangeListener(this@ViewHolder)
        }

        fun setData() {
            list[adapterPosition].also {
                textView1.text = it.title
                textView2.text = it.createTimeFormatted
            }
        }

        override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
            list[adapterPosition].checked = isChecked
            if(isChecked) ++checkedItemCount else --checkedItemCount
            if(checkedItemCount <= 1)
                (textView1.context as Activity).invalidateOptionsMenu() // 메뉴를 다시 그리라는 메소드
        }
    }

    var checkedItemCount = 0
    var layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(layoutInflater.inflate(R.layout.item2, viewGroup, false))

    override fun getItemCount(): Int =
            list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.setData()
}