package com.weatherapp.ui.recent

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weatherapp.WeatherApp
import com.weatherapp.data.AppRepository
import com.weatherapp.data.db.entity.City
import kotlinx.coroutines.launch
import javax.inject.Inject

class RecentSearchViewModel : ViewModel() {

    @Inject
    lateinit var appRepository: AppRepository

    val cityList: LiveData<List<City>>?

    init {
        WeatherApp.get()?.component?.inject(this)
        cityList = appRepository.getAllCity()
    }


    fun deleteAll() = viewModelScope.launch { appRepository.deleteAll() }
}