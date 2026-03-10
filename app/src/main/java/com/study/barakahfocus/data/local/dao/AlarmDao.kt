package com.study.barakahfocus.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.study.barakahfocus.data.local.entities.Alarm

@Dao
interface AlarmDao {
    @Insert
    fun insert(item: Alarm)

    @Query("SELECT * FROM alarm")
    fun getAll(): List<Alarm>

    @Query("DELETE FROM alarm WHERE id = :id")
    fun deleteById(id: Int)
}
