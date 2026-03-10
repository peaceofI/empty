package com.study.barakahfocus.data.repositories

import android.app.Application
import com.study.barakahfocus.BarakahFocusApp
import com.study.barakahfocus.data.local.AppDatabase
import com.study.barakahfocus.data.local.dao.StudySessionDao
import com.study.barakahfocus.data.local.entities.StudySession
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StudySessionRepository(application: Application) {
    private val dao: StudySessionDao = (application as BarakahFocusApp).database.studysessionDao()

    suspend fun insert(item: StudySession) {
        withContext(Dispatchers.IO) {
            dao.insert(item)
        }
    }

    // Add other methods as needed
}
