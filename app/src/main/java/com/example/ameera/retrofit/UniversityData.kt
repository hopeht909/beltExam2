package com.example.ameera.retrofit

class UniversityData : ArrayList<UniversityData.UniversityDataItem>(){
    data class UniversityDataItem(
        val alpha_two_code: String,
        val country: String,
        val domains: List<String>,
        val name: String,
        val web_pages: List<String>
    )
}