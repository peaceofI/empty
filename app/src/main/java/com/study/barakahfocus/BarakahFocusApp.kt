package com.study.barakahfocus

import android.app.Application
import androidx.room.Room
import com.study.barakahfocus.data.local.AppDatabase

class BarakahFocusApp : Application() {
    companion object {
        lateinit var instance: BarakahFocusApp
            private set
    }

    val database: AppDatabase by lazy {
        Room.databaseBuilder(this, AppDatabase::class.java, "barakah-db")
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
