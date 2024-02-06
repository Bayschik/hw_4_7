package com.example.hw_4_7.statisticActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hw_4_7.R
import com.example.hw_4_7.data.local.Statistic
import com.example.hw_4_7.databinding.ItemStatisticsBinding

class StatisticsAdapter(val onClick:(statistic:Statistic)->Boolean):Adapter<StatisticsAdapter.StatisticsViewHolder>() {

    private val list = arrayListOf<Statistic>()

    fun addStatistics(models: List<Statistic>){
        list.clear()
        list.addAll(models)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticsViewHolder {
        return StatisticsViewHolder(ItemStatisticsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: StatisticsViewHolder, position: Int) = holder.bind(list[position])

    inner class StatisticsViewHolder(private val binding: ItemStatisticsBinding):ViewHolder(binding.root){
        fun bind(statistic: Statistic) = with(binding) {
            tvStatusDetail.text = statistic.status?.replace("Результат: ", "")
            tvDifficultyDetail.text = statistic.difficulty?.replace("Сложность: ", "")
            tvMistakesDetail.text = statistic.mistakes
            imgIcon.setImageResource(if (statistic.status.equals("Результат: Победа")) R.drawable.ic_like else R.drawable.ic_dislike)
            imgSettings.setOnClickListener{
                onClick(statistic)
            }
        }

    }
}