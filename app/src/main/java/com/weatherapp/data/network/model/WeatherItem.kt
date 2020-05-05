package com.weatherapp.data.network.model

import com.squareup.moshi.Json

data class WeatherItem(

	@Json(name="description")
	val description: String? = null
)