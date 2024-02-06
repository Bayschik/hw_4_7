package com.example.hw_4_7.statisticActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_4_7.data.Repository
import com.example.hw_4_7.data.local.Statistic

class StatisticViewModel:ViewModel() {
    private val repository = Repository()
    fun getStatistic():LiveData<List<Statistic>> = repository.getStatistic()
}