package com.study.barakahfocus.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alarm")
data class Alarm(
    @PrimaryKey (autoGenerate = true
)
    id: Int, label: String, time: Long, enabled: Boolean, soundPath: String
)
