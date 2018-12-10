package net.skhu.e01button

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class Item (val title: String, var checked: Boolean = false) {

    companion object {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA)
    }

    var createTime = Date()

    var createTimeFormatted: String = dateFormat.format(createTime)
    set(time) {this.createTime = dateFormat.parse(time)}

    override fun toString(): String = "($title)"
}