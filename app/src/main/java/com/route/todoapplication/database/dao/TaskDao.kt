package com.route.todoapplication.database.dao

import androidx.room.*
import com.route.todoapplication.database.model.Task

@Dao
interface TaskDao {

    @Insert
    fun insertTask(task:Task)

    @Update
    fun updateTask(task:Task)

    @Delete
    fun deleteTask(task:Task)

    @Query("select * from task")
    fun getAllTasks():List<Task>

    @Query("select * from task where title like :title")
    fun searchByTitle(title:String):List<Task>
}