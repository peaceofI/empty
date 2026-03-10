package com.study.barakahfocus.data.repositories

import android.app.Application
import com.study.barakahfocus.BarakahFocusApp
import com.study.barakahfocus.data.local.AppDatabase
import com.study.barakahfocus.data.local.dao.SubjectDao
import com.study.barakahfocus.data.local.entities.Subject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SubjectRepository(application: Application) {
    private val dao: SubjectDao = (application as BarakahFocusApp).database.subjectDao()

    suspend fun insert(item: Subject) {
        withContext(Dispatchers.IO) {
            dao.insert(item)
        }
    }

    // Add other methods as needed
}
