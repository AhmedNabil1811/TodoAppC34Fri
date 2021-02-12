package com.route.todoapplication.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo var id:Int?=null,
    @ColumnInfo var title:String?=null,
    @ColumnInfo var description:String?=null,
    @ColumnInfo var isCompleted:Boolean?=null
)