package com.example.habitmonitor.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "stamps",
    foreignKeys=[
        ForeignKey(entity = Habit::class, parentColumns = ["id"], childColumns = ["habit_id"], onDelete = ForeignKey.CASCADE)
    ])
data class Stamp(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val habit_id:Long,
    val start_date:String,
    val start_time:String,
    val duration:Long,
    val description:String
)