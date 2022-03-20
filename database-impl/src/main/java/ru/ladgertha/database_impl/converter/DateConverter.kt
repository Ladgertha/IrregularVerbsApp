package ru.ladgertha.database_impl.converter

import androidx.room.TypeConverter
import java.util.*

object DateConverter {

    @TypeConverter
    @JvmStatic
    fun toDate(ms: Long?): Date? {
        if (ms == null) {
            return null
        }

        return Date(ms)
    }

    @TypeConverter
    @JvmStatic
    fun fromDate(date: Date?): Long? {
        if (date == null) {
            return null
        }

        return date.time
    }
}
