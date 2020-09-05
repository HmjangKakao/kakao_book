package com.hmjang.kakaobook.extension

import java.text.SimpleDateFormat
import java.util.*

val FORMAT_SERVER_DATE = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")

fun transformDate(date: String, transformFormat: String): String {
    return return if (date.isNullOrEmpty().not()) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = FORMAT_SERVER_DATE.parse(date).time
        val targetForm = SimpleDateFormat(transformFormat)
        targetForm.timeZone = TimeZone.getTimeZone("UTC")
        targetForm.format(calendar.time)
    } else ""
}