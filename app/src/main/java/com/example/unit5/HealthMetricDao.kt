package com.example.unit5

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HealthMetricDao {
    @Query("SELECT * FROM health_metrics ORDER BY id ASC")
    fun getAllMetrics(): LiveData<List<HealthMetric>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(metric: HealthMetric)

    @Query("DELETE FROM health_metrics")
    suspend fun deleteAll()
}