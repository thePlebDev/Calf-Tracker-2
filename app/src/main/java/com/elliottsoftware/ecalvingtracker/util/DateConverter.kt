package com.elliottsoftware.ecalvingtracker.util

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun fromTimeStamp(value:Long?):Date?{
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date:Date?): Long?{
        return date?.time
    }
}