package com.example.hw_4_7.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.hw_4_7.App
import com.example.hw_4_7.data.local.Statistic
import kotlinx.coroutines.Dispatchers

class Repository {
    fun addStatistic(model: Statistic): LiveData<Long> = liveData(Dispatchers.IO) {
        val insertedId = App.db.getDao().insert(model)
        emit(insertedId)
    }


    fun getStatistic(): LiveData<List<Statistic>> = liveData(Dispatchers.Main) {
        emit(App.db.getDao().getAll())
    }
}