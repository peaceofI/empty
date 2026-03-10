package com.study.barakahfocus.data.repositories

import android.app.Application
import com.study.barakahfocus.BarakahFocusApp
import com.study.barakahfocus.data.local.AppDatabase
import com.study.barakahfocus.data.local.dao.FlashcardDao
import com.study.barakahfocus.data.local.entities.Flashcard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FlashcardRepository(application: Application) {
    private val dao: FlashcardDao = (application as BarakahFocusApp).database.flashcardDao()

    suspend fun insert(item: Flashcard) {
        withContext(Dispatchers.IO) {
            dao.insert(item)
        }
    }

    // Add other methods as needed
}
