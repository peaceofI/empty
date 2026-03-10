package com.study.barakahfocus.ui.dashboard

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.study.barakahfocus.R
import com.study.barakahfocus.ui.timer.TimerActivity
import com.study.barakahfocus.utils.PermissionManager

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val tvTotalStudy = findViewById<TextView>(R.id.tv_total_study)
        val tvNextRoutine = findViewById<TextView>(R.id.tv_next_routine)
        val tvUpcomingTask = findViewById<TextView>(R.id.tv_upcoming_task)
        val tvNextPrayer = findViewById<TextView>(R.id.tv_next_prayer)
        val btnStartStudy = findViewById<CardView>(R.id.btn_start_study)
        val btnFocusMode = findViewById<CardView>(R.id.btn_focus_mode) // hypothetical
        val btnUsage = findViewById<CardView>(R.id.btn_usage)

        // Dummy data
        tvTotalStudy.text = "Today: 2h 15m"
        tvNextRoutine.text = "Next: Math Study at 4:00 PM"
        tvUpcomingTask.text = "Task: Finish Physics HW"
        tvNextPrayer.text = "Next Prayer: Asr 3:30 PM"

        // Request notification permission on start (for Android 13+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            PermissionManager.requestNotificationPermission(this) { granted ->
                if (!granted) {
                    Toast.makeText(this, "Notification permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnStartStudy.setOnClickListener {
            // Check overlay permission for timer overlay
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
                PermissionManager.showPermissionRationale(this, "Overlay permission is needed to show timer over other apps.") {
                    PermissionManager.requestOverlayPermission(this)
                }
            } else {
                startActivity(Intent(this, TimerActivity::class.java))
            }
        }

        // Example for focus mode: check usage stats permission
        btnFocusMode?.setOnClickListener {
            if (!PermissionManager.hasUsageStatsPermission(this)) {
                PermissionManager.showPermissionRationale(this, "Usage access permission is needed to block distracting apps.") {
                    PermissionManager.requestUsageStatsPermission(this)
                }
            } else {
                // Proceed to FocusModeActivity
                startActivity(Intent(this, FocusModeActivity::class.java))
            }
        }

        // Usage tracking
        btnUsage?.setOnClickListener {
            if (!PermissionManager.hasUsageStatsPermission(this)) {
                PermissionManager.requestUsageStatsPermission(this)
            } else {
                startActivity(Intent(this, UsageActivity::class.java))
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            PermissionManager.REQUEST_CODE_OVERLAY -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && Settings.canDrawOverlays(this)) {
                    startActivity(Intent(this, TimerActivity::class.java))
                } else {
                    Toast.makeText(this, "Overlay permission denied", Toast.LENGTH_SHORT).show()
                }
            }
            PermissionManager.REQUEST_CODE_USAGE -> {
                if (PermissionManager.hasUsageStatsPermission(this)) {
                    Toast.makeText(this, "Usage access granted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Usage access denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
