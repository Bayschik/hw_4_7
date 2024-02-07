package com.example.hw_4_7.mainActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.hw_4_7.data.local.Statistic
import com.example.hw_4_7.databinding.ActivityMainBinding
import com.example.hw_4_7.statisticActivity.StatisticsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        binding.btnAdd.setOnClickListener {
            val data = Statistic(
                status = binding.spinner.selectedItem.toString(),
                difficulty = binding.difficultySpinner.selectedItem.toString(),
                mistakes = binding.etMistakes.text.toString(),
                result = binding.etPoint.text.toString()
            )
            if (binding.etMistakes.text!!.isEmpty() && binding.etPoint.text!!.isEmpty()){
                Toast.makeText(this, "Вводите значения в поля", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.addStatistic(data).observe(this){
                    if (it != -1L){
                        Toast.makeText(this, "Данные успешно добавились", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Данные не были добавлены", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.btnStatistics.setOnClickListener {
            val intent = Intent(this, StatisticsActivity::class.java)
            startActivity(intent)
        }
    }
}