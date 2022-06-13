package com.elliottsoftware.ecalvingtracker.util

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.elliottsoftware.ecalvingtracker.dao.CalfDAO
import com.elliottsoftware.ecalvingtracker.database.AppDatabase
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
open class TestDatabaseSetup {

    protected lateinit var calfDAO: CalfDAO
    private lateinit var db: AppDatabase

    @Before
    fun createDB(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java)
            .allowMainThreadQueries().build()
        calfDAO = db.calfDao()
    }
    @After
    @Throws(IOException::class)
    fun closeDB(){
        db.close()
    }
}