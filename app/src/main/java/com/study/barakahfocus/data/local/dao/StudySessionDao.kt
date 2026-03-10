package com.study.barakahfocus.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.study.barakahfocus.data.local.entities.StudySession

@Dao
interface StudySessionDao {
    @Insert
    fun insert(item: StudySession)

    @Query("SELECT * FROM studysession")
    fun getAll(): List<StudySession>

    @Query("DELETE FROM studysession WHERE id = :id")
    fun deleteById(id: Int)
}
