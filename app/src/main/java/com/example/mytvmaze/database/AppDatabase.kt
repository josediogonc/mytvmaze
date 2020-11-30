package com.example.mytvmaze.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.mytvmaze.tvmaze.shows.model.PosterImage
import com.example.mytvmaze.tvmaze.shows.model.Rating
import com.example.mytvmaze.tvmaze.shows.model.Show

@Database(entities = [Show::class], exportSchema = false, version = 5)
@TypeConverters(
    PosterImageConverter::class,
    GenresConverter::class,
    RatingConverter::class,
    NetworkConverter::class,
    ScheduleConverter::class
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "tvmaze-database"
    }

    abstract fun showDao() : ShowDao

}

