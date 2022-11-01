package com.moejehad.unitonetask.presentation.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moejehad.unitonetask.domain.model.AllCities
import com.moejehad.unitonetask.domain.repository.AppRepository
import com.moejehad.unitonetask.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    var getAllCities = MutableLiveData<List<AllCities.DataContent.City>>()
    var getAllSliderCities = MutableLiveData<List<AllCities.DataContent.City>>()

    fun getAllCities() = viewModelScope.launch {
        when (val result = repository.getAllCites()) {
            is Resource.Success -> {
                result.data?.data?.slider?.let { getAllSliderCities.value = it }
                result.data?.data?.allCities?.let { getAllCities.value = it }
            }
            is Resource.Error -> {
                Log.e("MOE a", result.message.toString())
            }
        }
    }

}