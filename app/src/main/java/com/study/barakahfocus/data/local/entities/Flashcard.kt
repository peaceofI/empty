package com.study.barakahfocus.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flashcard")
data class Flashcard(
    @PrimaryKey (autoGenerate = true
)
    id: Int, question: String, answer: String, subject: String, difficulty: Int, nextReviewDate: Long
)
