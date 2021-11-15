package com.example.ameera.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UniversityDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUniversity(item: UniversityEntity)

    @Query("SELECT * FROM UniversityTable ORDER BY id ASC")
    fun getUniversity(): LiveData<List<UniversityEntity>>


    @Query("Delete from UniversityTable where ID=:universityID")
    suspend fun deleteUniversity(universityID: Int)

    @Query("UPDATE UniversityTable SET note=:updatedNote where ID=:uniID")
    suspend fun updateNote(updatedNote: String, uniID:Int)

}