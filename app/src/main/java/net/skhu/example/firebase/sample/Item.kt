package net.skhu.example.firebase.sample

import android.annotation.SuppressLint
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

class Item(){

    constructor(title: String):this(){
        this.title = title
    }

    lateinit var title: String
    var createTime: Date = Date()
    var iconIndex: Int = 0
    var checked: Boolean = false

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