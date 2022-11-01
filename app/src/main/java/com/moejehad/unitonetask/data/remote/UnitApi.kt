package com.moejehad.unitonetask.data.remote

import com.moejehad.unitonetask.data.remote.dto.AllCitiesDto
import retrofit2.http.GET

interface UnitApi {

    @GET("home/public")
    suspend fun getAllCities(): AllCitiesDto

}