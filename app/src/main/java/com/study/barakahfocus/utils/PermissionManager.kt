package com.study.barakahfocus.utils

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder

object PermissionManager {

    const val REQUEST_CODE_OVERLAY = 1001
    const val REQUEST_CODE_USAGE = 1002
    const val REQUEST_CODE_NOTIFICATION = 1003

    fun requestNotificationPermission(activity: AppCompatActivity, onResult: (Boolean) -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val launcher = activity.registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
                onResult(isGranted)
            }
            launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
        } else {
            onResult(true) // Not needed below Android 13
        }
    }

    fun requestOverlayPermission(activity: AppCompatActivity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(activity)) {
                val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:${activity.packageName}"))
                activity.startActivityForResult(intent, REQUEST_CODE_OVERLAY)
            }
        }
    }

    fun requestUsageStatsPermission(activity: AppCompatActivity) {
        if (!hasUsageStatsPermission(activity)) {
            val intent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)
            activity.startActivityForResult(intent, REQUEST_CODE_USAGE)
        }
    }

    fun hasUsageStatsPermission(context: Context): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val appOps = context.getSystemService(Context.APP_OPS_SERVICE) as android.app.AppOpsManager
            val mode = appOps.checkOpNoThrow(
                android.app.AppOpsManager.OPSTR_GET_USAGE_STATS,
                android.os.Process.myUid(),
                context.packageName
            )
            return mode == android.app.AppOpsManager.MODE_ALLOWED
        }
        return true
    }

    fun showPermissionRationale(activity: AppCompatActivity, message: String, onOk: () -> Unit) {
        MaterialAlertDialogBuilder(activity)
            .setTitle("Permission Required")
            .setMessage(message)
            .setPositiveButton("OK") { _, _ -> onOk() }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
