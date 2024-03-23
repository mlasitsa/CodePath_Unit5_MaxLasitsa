package com.example.unit5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.unit5.databinding.ItemMetricBinding

class MetricListAdapter : ListAdapter<HealthMetric, MetricListAdapter.MetricViewHolder>(MetricsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MetricViewHolder {
        return MetricViewHolder(ItemMetricBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MetricViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class MetricViewHolder(private val binding: ItemMetricBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(metric: HealthMetric) {
            binding.apply {
                foodNameText.text = metric.foodName
                caloriesText.text = metric.calories.toString()
            }
        }
    }

    class MetricsComparator : DiffUtil.ItemCallback<HealthMetric>() {
        override fun areItemsTheSame(oldItem: HealthMetric, newItem: HealthMetric): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: HealthMetric, newItem: HealthMetric): Boolean {
            return oldItem.id == newItem.id
        }
    }
}