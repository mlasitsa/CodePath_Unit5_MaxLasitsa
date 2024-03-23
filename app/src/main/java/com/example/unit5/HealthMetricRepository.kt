package com.example.unit5

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class HealthMetricRepository(private val healthMetricDao: HealthMetricDao) {

    val allMetrics: LiveData<List<HealthMetric>> = healthMetricDao.getAllMetrics()

    @WorkerThread
    suspend fun insert(healthMetric: HealthMetric) {
        healthMetricDao.insert(healthMetric)
    }
}