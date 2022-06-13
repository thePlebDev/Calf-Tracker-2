package com.elliottsoftware.ecalvingtracker.viewModels

import androidx.lifecycle.ViewModel
import com.elliottsoftware.ecalvingtracker.dao.CalfDAO
import com.elliottsoftware.ecalvingtracker.models.Calf
import kotlinx.coroutines.flow.Flow
import java.util.*

class CalfViewModel(private val calfDAO: CalfDAO): ViewModel() {

    suspend fun allCalves(): List<Calf> = calfDAO.getAllCalves()

    suspend fun getCalfByTagNumber(tagNumber: String): Calf = calfDAO.getByTagNumber(tagNumber)

    suspend fun saveCalf(tagNumber: String,details:String,cciaNumber:String):Unit{
        val calf:Calf = Calf(tagNumber,details,cciaNumber, Date())

        calfDAO.insertCalf(calf)
    }
}