package com.study.barakahfocus.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class TimerForegroundService : Service() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
