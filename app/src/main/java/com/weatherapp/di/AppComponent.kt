package com.weatherapp.di

import com.weatherapp.ui.home.HomeViewModel
import com.weatherapp.ui.recent.RecentSearchViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ServiceModule::class, DBModule::class, ApplicationModule::class))
interface AppComponent {

    fun inject(vm: HomeViewModel)

    fun inject(vm: RecentSearchViewModel)
}