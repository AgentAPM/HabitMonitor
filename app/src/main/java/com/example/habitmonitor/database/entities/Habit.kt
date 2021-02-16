package com.example.habitmonitor.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habits")
data class Habit(
        @PrimaryKey(autoGenerate = true)
        val id:Long,
        val name:String,
        val desirability: Int,
        val icon: Int
)