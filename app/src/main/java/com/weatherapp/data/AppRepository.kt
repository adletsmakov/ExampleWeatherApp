package com.weatherapp.data


import com.weatherapp.data.db.AppDao
import com.weatherapp.data.db.entity.City
import com.weatherapp.data.network.WeatherApi
import com.weatherapp.data.network.model.Response
import com.weatherapp.data.network.wrapper.Resource
import com.weatherapp.data.network.wrapper.ResponseHandler
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(
    @set:Inject
    var weatherApi: WeatherApi, @set:Inject var appDao: AppDao?
) {

    suspend fun weatherByCity(query: String): Resource<Response> =
        try {
            ResponseHandler.handleSuccess(weatherApi.weatherByCity(query))
        } catch (e: Exception) {
            ResponseHandler.handleException(e)
        }


    fun getAllCity() = appDao?.getAll()

    suspend fun saveCity(city: String?, country: String?) = appDao?.insert(City(city, country))

    suspend fun deleteAll() = appDao?.deleteAll()

    suspend fun getCityById(id: Int) = appDao?.getCityById(id)

    suspend fun isDBEmpty() = appDao?.isDBEmpty()
}