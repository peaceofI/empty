package com.study.barakahfocus.data.repositories

import android.app.Application
import com.study.barakahfocus.BarakahFocusApp
import com.study.barakahfocus.data.local.AppDatabase
import com.study.barakahfocus.data.local.dao.AppUsageDao
import com.study.barakahfocus.data.local.entities.AppUsage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppUsageRepository(application: Application) {
    private val dao: AppUsageDao = (application as BarakahFocusApp).database.appusageDao()

    suspend fun insert(item: AppUsage) {
        withContext(Dispatchers.IO) {
            dao.insert(item)
        }
    }

    // Add other methods as needed
}
