package com.study.barakahfocus.data.repositories

import android.app.Application
import com.study.barakahfocus.BarakahFocusApp
import com.study.barakahfocus.data.local.AppDatabase
import com.study.barakahfocus.data.local.dao.RoutineDao
import com.study.barakahfocus.data.local.entities.Routine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoutineRepository(application: Application) {
    private val dao: RoutineDao = (application as BarakahFocusApp).database.routineDao()

    suspend fun insert(item: Routine) {
        withContext(Dispatchers.IO) {
            dao.insert(item)
        }
    }

    // Add other methods as needed
}
