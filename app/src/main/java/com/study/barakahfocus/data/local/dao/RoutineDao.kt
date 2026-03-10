package com.study.barakahfocus.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.study.barakahfocus.data.local.entities.Routine

@Dao
interface RoutineDao {
    @Insert
    fun insert(item: Routine)

    @Query("SELECT * FROM routine")
    fun getAll(): List<Routine>

    @Query("DELETE FROM routine WHERE id = :id")
    fun deleteById(id: Int)
}
