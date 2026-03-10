package com.study.barakahfocus.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.study.barakahfocus.data.local.entities.Note

@Dao
interface NoteDao {
    @Insert
    fun insert(item: Note)

    @Query("SELECT * FROM note")
    fun getAll(): List<Note>

    @Query("DELETE FROM note WHERE id = :id")
    fun deleteById(id: Int)
}
