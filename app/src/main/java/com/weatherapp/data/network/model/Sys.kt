package com.weatherapp.data.network.model

import com.squareup.moshi.Json

data class Sys(

	@Json(name="country")
	val country: String? = null
)