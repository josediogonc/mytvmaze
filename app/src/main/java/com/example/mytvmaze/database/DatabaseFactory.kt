package com.example.mytvmaze.database

import android.content.Context
import androidx.room.Room

object DatabaseFactory {

    fun build(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

}