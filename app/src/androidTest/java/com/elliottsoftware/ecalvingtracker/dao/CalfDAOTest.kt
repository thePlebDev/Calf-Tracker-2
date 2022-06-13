package com.elliottsoftware.ecalvingtracker.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.elliottsoftware.ecalvingtracker.database.AppDatabase
import com.elliottsoftware.ecalvingtracker.models.Calf
import com.elliottsoftware.ecalvingtracker.util.TestDatabaseSetup
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.*
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class CalfDAOTest : TestDatabaseSetup(){


    /**
     * Testing getAllCalves() method on the DAO
     * */
    @Test
    @Throws(Exception::class)
    fun findAllCalves() = runBlocking{
        //GIVEN
        val calf: Calf = Calf("33e3","another one","333r3", Date(),"Bull")

        //WHEN
        calfDAO.insertCalf(calf)
        val calfList:List<Calf> = calfDAO.getAllCalves()

        //THEN
        assertEquals(calfList.size,1)
    }

    /**
     * Testing getByTagNumber() method on the DAO
     * */
    @Test
    @Throws(Exception::class)
    fun getByTagNumberTest() = runBlocking {
        //GIVEN
        val TAG_NUMBER:String = "223FFDRE"
        val calf: Calf = Calf(TAG_NUMBER,"another one","333r3", Date(),"Bull")

        //WHEN
        calfDAO.insertCalf(calf)
        val foundCalf = calfDAO.getByTagNumber(TAG_NUMBER)

        //THEN
        assertEquals(TAG_NUMBER,foundCalf.tagNumber)

    }



}