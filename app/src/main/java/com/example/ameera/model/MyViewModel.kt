package com.example.ameera.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.ameera.database.UniversityDatabase
import com.example.ameera.database.UniversityEntity
import com.example.ameera.database.UniversityRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(application: Application): AndroidViewModel(application) {
    private val repository: UniversityRepository
    private val university: LiveData<List<UniversityEntity>>

    init {
        val universityDao = UniversityDatabase.getDatabase(application).universityDao()
        repository = UniversityRepository(universityDao)
        university = repository.getUniversity
    }

    fun getUniversityDB(): LiveData<List<UniversityEntity>>{
        return university
    }

    fun addUniversityDB(universityName: String, country: String, note: String){
        CoroutineScope(Dispatchers.IO).launch {
            repository.addUniversity(UniversityEntity(0,universityName,country,note))
        }
    }

    fun deleteUniversityDB(ID : Int){
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteUniversity(ID)
        }
    }
    fun updateUniversityDB(newNote :String, id : Int){
        CoroutineScope(Dispatchers.IO).launch {
            repository.updateNote(newNote,id)
        }
    }
}