package com.example.hw_4_7.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_4_7.data.Repository
import com.example.hw_4_7.data.local.Statistic

class MainViewModel:ViewModel() {
    private val repository = Repository()
    fun addStatistic(model:Statistic): LiveData<Long> = repository.addStatistic(model)
}