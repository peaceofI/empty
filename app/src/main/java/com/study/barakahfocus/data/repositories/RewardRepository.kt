package com.study.barakahfocus.data.repositories

import android.app.Application
import com.study.barakahfocus.BarakahFocusApp
import com.study.barakahfocus.data.local.AppDatabase
import com.study.barakahfocus.data.local.dao.RewardDao
import com.study.barakahfocus.data.local.entities.Reward
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RewardRepository(application: Application) {
    private val dao: RewardDao = (application as BarakahFocusApp).database.rewardDao()

    suspend fun insert(item: Reward) {
        withContext(Dispatchers.IO) {
            dao.insert(item)
        }
    }

    // Add other methods as needed
}
