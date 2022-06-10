package com.elliottsoftware.ecalvingtracker.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.elliottsoftware.ecalvingtracker.dao.CalfDAO

class CalfViewModelFactory(
    private val calfDAO: CalfDAO
) : ViewModelProvider.Factory {
    // TODO: explain what is going on with this weird syntax
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CalfViewModel::class.java)){
            return CalfViewModel(calfDAO) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}