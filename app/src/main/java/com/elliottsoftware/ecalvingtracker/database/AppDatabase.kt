package com.elliottsoftware.ecalvingtracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.elliottsoftware.ecalvingtracker.dao.CalfDAO
import com.elliottsoftware.ecalvingtracker.models.Calf
import com.elliottsoftware.ecalvingtracker.util.DateConverter

@Database(entities = [Calf::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun calfDao():CalfDAO companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }

}