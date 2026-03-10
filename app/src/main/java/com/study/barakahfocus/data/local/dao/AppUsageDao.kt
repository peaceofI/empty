package com.study.barakahfocus.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.study.barakahfocus.data.local.entities.AppUsage

@Dao
interface AppUsageDao {
    @Insert
    fun insert(item: AppUsage)

    @Query("SELECT * FROM appusage")
    fun getAll(): List<AppUsage>

    @Query("DELETE FROM appusage WHERE id = :id")
    fun deleteById(id: Int)
}
