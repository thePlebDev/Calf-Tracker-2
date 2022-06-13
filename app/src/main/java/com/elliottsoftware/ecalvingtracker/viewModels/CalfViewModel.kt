package com.elliottsoftware.ecalvingtracker.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elliottsoftware.ecalvingtracker.dao.CalfDAO
import com.elliottsoftware.ecalvingtracker.models.Calf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.util.*

class CalfViewModel(private val calfDAO: CalfDAO): ViewModel() {

    suspend fun allCalves(): List<Calf> {

        return calfDAO.getAllCalves()
    }

    suspend fun getCalfByTagNumber(tagNumber: String): Calf = calfDAO.getByTagNumber(tagNumber)

     fun saveCalf(tagNumber: String,details:String,cciaNumber:String,sex:String):Unit{
        val calf:Calf = Calf(tagNumber,details,cciaNumber, Date(),sex)
        viewModelScope.launch {
            calfDAO.insertCalf(calf)
        }

    }
}