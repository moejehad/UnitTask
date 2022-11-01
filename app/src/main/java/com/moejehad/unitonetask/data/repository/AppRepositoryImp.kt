package com.moejehad.unitonetask.data.repository

import android.app.Activity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.moejehad.unitonetask.data.remote.UnitApi
import com.moejehad.unitonetask.domain.model.AllCities
import com.moejehad.unitonetask.domain.repository.AppRepository
import com.moejehad.unitonetask.utils.Resource
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AppRepositoryImp @Inject constructor(
    private val api: UnitApi
) : AppRepository {

    private lateinit var lastVerificationCode: String

    override suspend fun getAllCites(): Resource<AllCities> {
        return try {
            val response = api.getAllCities()
            when (response.status) {
                true -> {
                    Resource.Success(response.toAllCities())
                }
                else -> {
                    Resource.Error(response.message)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "unknown error occurred.")
        }
    }


}
