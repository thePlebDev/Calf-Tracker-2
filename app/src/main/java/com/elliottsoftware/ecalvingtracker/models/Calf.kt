package com.elliottsoftware.ecalvingtracker.models

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity
data class Calf(
    @ColumnInfo(name="tag_number")
    val tagNumber: String,
    @ColumnInfo(name="details")
    val details:String,
    @ColumnInfo(name="ccia_number")
    val cciaNumber:String,
    @ColumnInfo(name="date_born")
    val date:Date,
    @PrimaryKey(autoGenerate = true)
    val id: Long =0
//    @ColumnInfo(name="date_born")
//    val dateBorn: Long = System.currentTimeMillis()
){
//    val createdDateFormatted: String
//        get() = DateFormat.getDateInstance().format(dateBorn)



}
