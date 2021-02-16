package com.route.todoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.todoapplication.adapter.TasksAdapter
import com.route.todoapplication.database.TasksDataBase
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    lateinit var adapter: TasksAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        adapter = TasksAdapter(listOf())
        recycler_view.adapter = adapter
        add_btn.setOnClickListener{
            gotoAddTask()
        }
    }

    override fun onStart() {
        super.onStart()
        val tasksList = TasksDataBase.getInstance(applicationContext)
            .TasksDao()
            .getAllTasks();
        adapter.changeData(tasksList)

    }

    private fun gotoAddTask() {
        val intent = Intent(this,AddTaskActivity::class.java)
        startActivity(intent)

    }
}