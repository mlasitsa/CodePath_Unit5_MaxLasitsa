package com.example.unit5

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HealthMetricViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: HealthMetricRepository
    val allMetrics: LiveData<List<HealthMetric>>

    init {
        val metricsDao = AppDatabase.getDatabase(application).healthMetricDao()
        repository = HealthMetricRepository(metricsDao)
        allMetrics = repository.allMetrics
    }

    fun insert(healthMetric: HealthMetric) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(healthMetric)
    }
}