package com.weatherapp.data.network.model

import com.squareup.moshi.Json

data class Wind(

	@Json(name="speed")
	val speed: Double? = null
)