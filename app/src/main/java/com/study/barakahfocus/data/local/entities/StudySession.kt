package com.study.barakahfocus.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "studysession")
data class StudySession(
    @PrimaryKey (autoGenerate = true
)
    id: Int, subject: String, startTime: Long, endTime: Long, duration: Int
)
