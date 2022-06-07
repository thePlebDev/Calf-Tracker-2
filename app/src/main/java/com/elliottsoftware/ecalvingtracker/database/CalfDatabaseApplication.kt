package com.elliottsoftware.ecalvingtracker.database

import android.app.Application

class CalfDatabaseApplication :Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}