package com.elliottsoftware.ecalvingtracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.elliottsoftware.ecalvingtracker.dao.CalfDAO
import com.elliottsoftware.ecalvingtracker.models.Calf

@Database(entities = [Calf::class], version = 1)
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
                    .createFromAsset("database.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }

}