package com.example.ameera.database

import androidx.room.Entity
import androidx.room.PrimaryKey


//table name
@Entity(tableName = "UniversityTable")
data class UniversityEntity(

    // table contents
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val universityName: String,
    val country: String,
    val note: String = ""
)