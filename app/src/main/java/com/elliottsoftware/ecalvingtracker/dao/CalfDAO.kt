package com.elliottsoftware.ecalvingtracker.dao

import androidx.room.*
import com.elliottsoftware.ecalvingtracker.models.Calf
import kotlinx.coroutines.flow.Flow

@Dao
interface CalfDAO {

    @Query("SELECT * FROM calf")
    fun getAllCalves(): Flow<List<Calf>>

    @Query("SELECT * FROM calf WHERE tag_number = :tagNumber")
    suspend fun getByTagNumber(tagNumber: String): Calf

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCalf(calf: Calf)

    @Update
    suspend fun updateCalf(calf: Calf)

    @Delete
    suspend fun deleteCalf(calf: Calf)
}