package com.study.barakahfocus.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task(
    @PrimaryKey (autoGenerate = true
)
    id: Int, title: String, subject: String, deadline: Long, priority: Int, estimatedTime: Int, completed: Boolean
)
