package com.moejehad.unitonetask.domain.repository

import android.app.Activity
import com.moejehad.unitonetask.domain.model.AllCities
import com.moejehad.unitonetask.utils.Resource

interface AppRepository {

    suspend fun getAllCites(): Resource<AllCities>

}