package net.skhu.e01button

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyRecyclerViewAdapter(context: Context, private val list: MutableList<String>) : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById<TextView>(R.id.textView)
    }

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
            ViewHolder(layoutInflater.inflate(R.layout.item, viewGroup, false))

    override fun getItemCount() =
            list.size

    override fun onBindViewHolder(holder: ViewHolder, index: Int) {
        holder.textView.text = list[index]
    }
}