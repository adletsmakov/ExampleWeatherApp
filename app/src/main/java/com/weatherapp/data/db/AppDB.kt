package com.weatherapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.weatherapp.data.db.entity.City

@Database(entities = [City::class], version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun appDao(): AppDao
}