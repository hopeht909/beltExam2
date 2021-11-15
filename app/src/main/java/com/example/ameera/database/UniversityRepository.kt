package com.example.ameera.database

import androidx.lifecycle.LiveData


class UniversityRepository(private val universityDao: UniversityDao) {

    val getUniversity: LiveData<List<UniversityEntity>> = universityDao.getUniversity()

    suspend fun addUniversity(item: UniversityEntity){
        universityDao.addUniversity(item)
    }


    suspend fun deleteUniversity(universityID : Int){
        universityDao.deleteUniversity(universityID)
    }
    suspend fun updateNote(updatedNote: String, id : Int){
        universityDao.updateNote(updatedNote, id)
    }

}