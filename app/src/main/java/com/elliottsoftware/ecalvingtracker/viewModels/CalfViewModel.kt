package com.elliottsoftware.ecalvingtracker.viewModels

import androidx.lifecycle.ViewModel
import com.elliottsoftware.ecalvingtracker.dao.CalfDAO
import com.elliottsoftware.ecalvingtracker.models.Calf
import kotlinx.coroutines.flow.Flow

class CalfViewModel(private val calfDAO: CalfDAO): ViewModel() {

    suspend fun allCalves(): List<Calf> = calfDAO.getAllCalves()

    suspend fun getCalfByTagNumber(tagNumber: String): Calf = calfDAO.getByTagNumber(tagNumber)
}