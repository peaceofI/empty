package com.study.barakahfocus.ui.subjects

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.study.barakahfocus.R

class SubjectsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subjects)

        val listView = findViewById<ListView>(R.id.list_subjects)
        val subjects = arrayOf("Mathematics", "Physics", "Chemistry", "Biology")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjects)
        listView.adapter = adapter
    }
}
