package com.weatherapp

import android.app.Application
import com.weatherapp.di.AppComponent
import com.weatherapp.di.ApplicationModule
import com.weatherapp.di.DaggerAppComponent

class WeatherApp : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        component = DaggerAppComponent.builder().applicationModule(ApplicationModule(this)).build()
    }

    companion object {
        private var instance: WeatherApp? = null
        fun get(): WeatherApp? = instance
    }
}