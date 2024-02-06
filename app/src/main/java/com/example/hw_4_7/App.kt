package com.example.hw_4_7

import android.app.Application
import androidx.room.Room
import com.example.hw_4_7.data.local.AppDatabase

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "database-name"
        ).allowMainThreadQueries().build()
    }

    companion object{
        lateinit var db:AppDatabase
    }
}