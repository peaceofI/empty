package com.study.barakahfocus.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.study.barakahfocus.data.local.entities.Task

@Dao
interface TaskDao {
    @Insert
    fun insert(item: Task)

    @Query("SELECT * FROM task")
    fun getAll(): List<Task>

    @Query("DELETE FROM task WHERE id = :id")
    fun deleteById(id: Int)
}
