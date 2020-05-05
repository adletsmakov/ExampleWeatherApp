package com.weatherapp.di

import android.app.Application
import androidx.room.Room
import com.weatherapp.data.db.AppDB
import com.weatherapp.data.db.AppDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {

    @Provides
    @Singleton
    fun dao(app: Application): AppDao = Room.databaseBuilder(
        app, AppDB::class.java, "app-db"
    ).build().appDao()
}