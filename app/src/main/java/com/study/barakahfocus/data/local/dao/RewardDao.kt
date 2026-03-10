package com.study.barakahfocus.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.study.barakahfocus.data.local.entities.Reward

@Dao
interface RewardDao {
    @Insert
    fun insert(item: Reward)

    @Query("SELECT * FROM reward")
    fun getAll(): List<Reward>

    @Query("DELETE FROM reward WHERE id = :id")
    fun deleteById(id: Int)
}
