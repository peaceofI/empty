package com.study.barakahfocus.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.study.barakahfocus.data.local.entities.PrayerTime

@Dao
interface PrayerTimeDao {
    @Insert
    fun insert(item: PrayerTime)

    @Query("SELECT * FROM prayertime")
    fun getAll(): List<PrayerTime>

    @Query("DELETE FROM prayertime WHERE id = :id")
    fun deleteById(id: Int)
}
