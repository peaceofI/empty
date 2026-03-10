package com.study.barakahfocus.data.repositories

import android.app.Application
import com.study.barakahfocus.BarakahFocusApp
import com.study.barakahfocus.data.local.AppDatabase
import com.study.barakahfocus.data.local.dao.AlarmDao
import com.study.barakahfocus.data.local.entities.Alarm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AlarmRepository(application: Application) {
    private val dao: AlarmDao = (application as BarakahFocusApp).database.alarmDao()

    suspend fun insert(item: Alarm) {
        withContext(Dispatchers.IO) {
            dao.insert(item)
        }
    }

    // Add other methods as needed
}
