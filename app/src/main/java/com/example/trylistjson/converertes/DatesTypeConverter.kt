package com.example.trylistjson.converertes

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class DatesTypeConverter {
    private val parser = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    @TypeConverter
    fun fromDate(date: Date): String? {
        parser.timeZone = TimeZone.getDefault()
        return parser.format(date ?: Date())
    }

    @TypeConverter
    fun ToData(str: String): Date? {
        parser.timeZone = TimeZone.getDefault()
        return if (str != null) {
            parser.parse(str)
        } else Date()

    }
}