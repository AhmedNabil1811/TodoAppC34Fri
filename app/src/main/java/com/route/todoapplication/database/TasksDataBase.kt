package com.route.todoapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.route.todoapplication.database.dao.TaskDao
import com.route.todoapplication.database.model.Task

@Database(entities = [Task::class],version = 1,exportSchema = false)
abstract class TasksDataBase :RoomDatabase(){

    abstract fun TasksDao():TaskDao

    companion object{
        private var myDataBase:TasksDataBase? =null
        val DATABASE_NAME = "tasks-db";

        fun getInstance(context: Context):TasksDataBase{
            if(myDataBase==null){
                //create database
                myDataBase = Room.databaseBuilder(context,
                TasksDataBase::class.java,
                DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                ;
            }
            return myDataBase!!
        }
    }
}