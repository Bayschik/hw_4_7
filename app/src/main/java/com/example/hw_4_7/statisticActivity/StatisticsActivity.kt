package com.example.hw_4_7.statisticActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.example.hw_4_7.App
import com.example.hw_4_7.data.local.Statistic
import com.example.hw_4_7.databinding.ActivityStatisticsBinding

class StatisticsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityStatisticsBinding
    private val viewModel:StatisticViewModel by viewModels()
    private val adapter = StatisticsAdapter(this::onLongClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatisticsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter

        viewModel.getStatistic().observe(this){statistic->
            adapter.addStatistics(statistic)
        }
    }

    private fun onLongClick(position: Statistic): Boolean {
        val alertDialBuilder = AlertDialog.Builder(this)
            .setMessage("Вы хотите удалить статистику?")

            .setPositiveButton("Да") { _, _ ->
                App.db.getDao().delete(position)
                adapter.notifyDataSetChanged()
            }

            .setNegativeButton("Нет"){_,_ ->
                dismissKeyboardShortcutsHelper()
            }

        val alertDialog = alertDialBuilder.create()
        alertDialog.show()
        return true
    }
}