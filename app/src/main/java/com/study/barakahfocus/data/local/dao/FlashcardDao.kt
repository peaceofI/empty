package com.study.barakahfocus.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.study.barakahfocus.data.local.entities.Flashcard

@Dao
interface FlashcardDao {
    @Insert
    fun insert(item: Flashcard)

    @Query("SELECT * FROM flashcard")
    fun getAll(): List<Flashcard>

    @Query("DELETE FROM flashcard WHERE id = :id")
    fun deleteById(id: Int)
}
