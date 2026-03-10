package com.study.barakahfocus.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.study.barakahfocus.data.local.dao.*
import com.study.barakahfocus.data.local.entities.*

@Database(
    entities = [
        Subject::class,
        Task::class,
        Flashcard::class,
        Note::class,
        StudySession::class,
        Routine::class,
        AppUsage::class,
        Reward::class,
        PrayerTime::class,
        Alarm::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun subjectDao(): SubjectDao
    abstract fun taskDao(): TaskDao
    abstract fun flashcardDao(): FlashcardDao
    abstract fun noteDao(): NoteDao
    abstract fun studySessionDao(): StudySessionDao
    abstract fun routineDao(): RoutineDao
    abstract fun appUsageDao(): AppUsageDao
    abstract fun rewardDao(): RewardDao
    abstract fun prayerTimeDao(): PrayerTimeDao
    abstract fun alarmDao(): AlarmDao
}
