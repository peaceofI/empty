package com.study.barakahfocus.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.study.barakahfocus.data.local.entities.Subject

@Dao
interface SubjectDao {
    @Insert
    fun insert(item: Subject)

    @Query("SELECT * FROM subject")
    fun getAll(): List<Subject>

    @Query("DELETE FROM subject WHERE id = :id")
    fun deleteById(id: Int)
}
