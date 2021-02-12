package com.route.todoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.todoapplication.database.TasksDataBase

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}