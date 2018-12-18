package net.skhu.example.firebase.recyclerView

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import kotlinx.android.synthetic.main.item_with_time.view.*
import net.skhu.example.R

class MyRecyclerViewAdapter(
        context: Context,
        val itemList: ItemList<Item>
) : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view),
            CompoundButton.OnCheckedChangeListener,
            View.OnClickListener {

        init { view.setOnClickListener(this) }

        private val textView1 = view.findViewById<TextView>(R.id.textView1)
        private val textView2 = view.findViewById<TextView>(R.id.textView2)
        private val checkBox = view.findViewById<CheckBox>(R.id.checkBox).apply {
            setOnCheckedChangeListener(this@ViewHolder)
        }

        fun setData() {
            this@MyRecyclerViewAdapter.itemList.getItem(super.getAdapterPosition())
                    .also {
                        this@ViewHolder.textView1.text = it.title
                        this@ViewHolder.textView2.text = it.getCreateTimeFormatted()
                        this@ViewHolder.checkBox.isChecked = it.checked
                    }
        }

        override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
            this@MyRecyclerViewAdapter.itemList.also {
                it.getItem(super.getAdapterPosition()).checked = isChecked
                if(it.getCount { item -> item.checked } <= 1) (textView1.context as Activity).invalidateOptionsMenu()
            }
        }

        override fun onClick(view: View) {
            (view.context as MainActivity).showItemEditDialog(super.getAdapterPosition())
        }
    }

    override fun getItemCount(): Int =
            this.itemList.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(layoutInflater.inflate(R.layout.item_with_time, viewGroup, false))

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) =
            viewHolder.setData()
}