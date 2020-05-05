package com.weatherapp.ui.home

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.weatherapp.WeatherApp
import com.weatherapp.data.AppRepository
import com.weatherapp.data.network.model.Response
import com.weatherapp.data.network.wrapper.Resource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class HomeViewModel : ViewModel() {

    @Inject
    lateinit var appRepository: AppRepository

    var data: Response? = null
    val weatherObservableField = ObservableField<Response?>()

    init {
        WeatherApp.get()?.component?.inject(this)
    }

    fun postResponse(response:Response?){
        data = response
        weatherObservableField.set(data)
    }

    fun weatherByCity(cityName: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = appRepository.weatherByCity(cityName)
        emit(response)
    }

    fun saveCity(city: String?, country:String?) = liveData(Dispatchers.IO) {
        emit(appRepository.saveCity(city, country))
    }

    fun getCityById(id:Int) = liveData(Dispatchers.IO) {
        emit(appRepository.getCityById(id))
    }

    fun isDBEmpty() = liveData(Dispatchers.IO) {
        emit(appRepository.isDBEmpty())
    }

    fun temperature(temp:Double?):String {
        val toCelsius = 273.15 //value to convert to celsius.
        return temp?.minus( toCelsius)?.toInt().toString()
    }

    fun windSpeed(speed:Double?):String {
        val toKph = 3.6 //value to convert to kilometer per hour.
        return speed?.times(toKph)?.toInt().toString()
    }

}
