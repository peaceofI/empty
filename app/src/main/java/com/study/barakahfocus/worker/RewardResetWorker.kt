package com.study.barakahfocus.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class RewardResetWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        return Result.success()
    }
}
