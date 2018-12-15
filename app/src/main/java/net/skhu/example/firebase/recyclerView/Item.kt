package net.skhu.example.firebase.recyclerView

import android.annotation.SuppressLint
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

class Item(
        val title: String,
        var createTime: Date = Date(),
        var checked: Boolean = false
) : Serializable{

    companion object {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    }

    fun getCreateTimeFormatted(): String =
            format.format(this.createTime)

    fun setCreateTimeFormatted(s: String) {
        this.createTime = format.parse(s)
    }

    override fun toString(): String =
            "($title)"
}