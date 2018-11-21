package net.skhu.e01button

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class Item2 (val title: String, var checked: Boolean = false) {

    companion object {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA)
    }

    val createTime = Date()
    val createTimeFormatted = dateFormat.format(createTime)
}