package com.elliottsoftware.ecalvingtracker.models

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Calf(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name="tag_number")
    val tagNumber: String,
    @ColumnInfo(name="details")
    val details:String,
    @ColumnInfo(name="date_born")
    val dateBorn: Long = System.currentTimeMillis()
) : Parcelable {
    val createdDateFormatted: String
        get() = DateFormat.getDateInstance().format(dateBorn)



}
