package com.moejehad.unitonetask.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.moejehad.unitonetask.domain.model.AllCities

data class AllCitiesDto(
    @SerializedName("data") val data: DataContentDto,
    @SerializedName("status") val status: Boolean,
    @SerializedName("errors") val errors: List<String>,
    @SerializedName("message") val message: String
) {
    data class DataContentDto(
        @SerializedName("allCities") val allCities: List<CityDto>,
        @SerializedName("slider") val slider: List<CityDto>
    ) {
        data class CityDto(
            @SerializedName("id") val id: Int,
            @SerializedName("imageURL") val imageURL: String,
            @SerializedName("name") val name: String
        ) {
            fun toCity(): AllCities.DataContent.City {
                return AllCities.DataContent.City(
                    id = id,
                    imageURL = imageURL,
                    name = name
                )
            }
        }

        fun toDataContent(): AllCities.DataContent {
            return AllCities.DataContent(
                allCities = allCities.map { it.toCity() },
                slider = slider.map { it.toCity() },
            )
        }

    }

    fun toAllCities(): AllCities {
        return AllCities(
            data = data.toDataContent(),
            status = status,
            errors = errors,
            message = message
        )
    }

}
