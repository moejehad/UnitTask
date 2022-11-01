package com.moejehad.unitonetask.di

import com.moejehad.unitonetask.data.database.FirebaseAuth
import com.moejehad.unitonetask.data.remote.UnitApi
import com.moejehad.unitonetask.data.repository.AppRepositoryImp
import com.moejehad.unitonetask.domain.repository.AppRepository
import com.moejehad.unitonetask.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDriverRepository(
        api: UnitApi
    ): AppRepository {
        return AppRepositoryImp(api)
    }

    @Provides
    @Singleton
    fun provideDriverApi(): UnitApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UnitApi::class.java)
    }




}