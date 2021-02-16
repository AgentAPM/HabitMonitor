package com.example.habitmonitor.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.habitmonitor.database.entities.Habit
import com.example.habitmonitor.database.entities.Stamp

@Database(entities = [Habit::class, Stamp::class], version = 1, exportSchema = false)
abstract class HabitDatabase:RoomDatabase() {
    abstract val habitDatabaseDAO: HabitDatabaseDAO

    companion object {
        @Volatile
        private var INSTANCE: HabitDatabase? = null

        fun getInstance(context: Context): HabitDatabase {
            synchronized(this){
                var instance = INSTANCE
                if( instance==null ) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            HabitDatabase::class.java,
                            "habit_monitor_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}