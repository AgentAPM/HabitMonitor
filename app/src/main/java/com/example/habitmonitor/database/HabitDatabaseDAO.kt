package com.example.habitmonitor.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.habitmonitor.database.entities.Habit
import com.example.habitmonitor.database.entities.Stamp

@Dao
interface HabitDatabaseDAO {
    @Insert
    fun addHabit(habit:Habit)
    @Delete
    fun deleteHabit(habit:Habit)
    @Update
    fun updateHabit(habit: Habit)

    @Insert
    fun addStamp(stamp:Stamp)
    @Delete
    fun deleteStamp(stamp:Stamp)
    @Update
    fun updateStamp(stamp: Stamp)

    @Query("SELECT * FROM habits")
    fun getAllHabits(): LiveData<List<Habit>>
    @Query("SELECT * FROM stamps WHERE habit_id = :habitId")
    fun getHabitStamps(habitId:Long): LiveData<List<Stamp>>
    @Query("SELECT * FROM stamps WHERE habit_id = :habitId ORDER BY start_date, start_time ASC LIMIT 1")
    fun getOldestStamp(habitId:Long): LiveData<Stamp>
    @Query("SELECT * FROM stamps WHERE habit_id = :habitId ORDER BY start_date, start_time DESC LIMIT 1")
    fun getNewestStamp(habitId:Long): LiveData<Stamp>
    @Query("SELECT COUNT(DISTINCT start_date) FROM stamps WHERE habit_id = :habitId")
    fun getStampDaysCount(habitId: Long): LiveData<Int>
    @Query("SELECT SUM(duration) FROM stamps WHERE habit_id = :habitId")
    fun getStampTotalDuration(habitId: Long): LiveData<Long>
}