package com.study.barakahfocus.ui.timer

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.study.barakahfocus.R
import java.util.concurrent.TimeUnit

class TimerActivity : AppCompatActivity() {
    private lateinit var tvTimer: TextView
    private lateinit var btnStart: Button
    private var timer: CountDownTimer? = null
    private var isRunning = false
    private var timeLeft = 25 * 60 * 1000L // 25 minutes default

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        tvTimer = findViewById(R.id.tv_timer)
        btnStart = findViewById(R.id.btn_start)

        updateTimerText()

        btnStart.setOnClickListener {
            if (isRunning) {
                pauseTimer()
            } else {
                startTimer()
            }
        }
    }

    private fun startTimer() {
        timer = object : CountDownTimer(timeLeft, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = millisUntilFinished
                updateTimerText()
            }

            override fun onFinish() {
                isRunning = false
                btnStart.text = "Start"
                // Play sound, notify, etc.
            }
        }.start()
        isRunning = true
        btnStart.text = "Pause"
    }

    private fun pauseTimer() {
        timer?.cancel()
        isRunning = false
        btnStart.text = "Start"
    }

    private fun updateTimerText() {
        val minutes = TimeUnit.MILLISECONDS.toMinutes(timeLeft)
        val seconds = TimeUnit.MILLISECONDS.toSeconds(timeLeft) - TimeUnit.MINUTES.toSeconds(minutes)
        tvTimer.text = String.format("%02d:%02d", minutes, seconds)
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}
