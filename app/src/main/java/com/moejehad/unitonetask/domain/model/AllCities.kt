package com.moejehad.unitonetask.domain.model

data class AllCities(
    val data: DataContent,
    val status: Boolean,
    val errors: List<String>,
    val message: String
) {
    data class DataContent(
        val allCities: List<City>,
        val slider: List<City>
    ) {
        data class City(
            val id: Int,
            val imageURL: String,
            val name: String
        )
    }
}
