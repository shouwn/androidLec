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

class E06RecyclerViewAdapter(context: Context, val list: MutableList<Item>) : RecyclerView.Adapter<E06RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), CompoundButton.OnCheckedChangeListener, View.OnClickListener{

        val textView1 = view.findViewById<TextView>(R.id.textView1)!!
        val textView2 = view.findViewById<TextView>(R.id.textView2)!!
        val checkBox = view.findViewById<CheckBox>(R.id.checkBox)!!.apply {
            setOnCheckedChangeListener(this@ViewHolder)
        }

        init {
            view.setOnClickListener(this)
        }

        fun setData(){
            list[super.getAdapterPosition()].also {
                this.textView1.text = it.title
                this.textView2.text = it.createTimeFormatted
                this.checkBox.isChecked = it.checked
            }
        }

        override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
            list[super.getAdapterPosition()].checked = isChecked
            if(isChecked) ++checkedItemCount else --checkedItemCount
            if(checkedItemCount <= 1)
                (textView1.context as Activity).invalidateOptionsMenu()
        }

        override fun onClick(view: View) {
            (view.context as E06List).showItemEditDialog(super.getAdapterPosition())
        }

    }

    private val layoutInflater = LayoutInflater.from(context)!!
    var checkedItemCount = 0

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = layoutInflater.inflate(R.layout.item2, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int =
            list.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
            viewHolder.setData()
}