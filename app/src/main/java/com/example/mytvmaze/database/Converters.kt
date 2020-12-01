package com.example.mytvmaze.database

import androidx.room.TypeConverter
import com.example.mytvmaze.tvmaze.shows.model.Network
import com.example.mytvmaze.tvmaze.shows.model.PosterImage
import com.example.mytvmaze.tvmaze.shows.model.Rating
import com.example.mytvmaze.tvmaze.shows.model.Schedule

class PosterImageConverter {

    @TypeConverter
    fun fromString(images : String) : PosterImage {
        val array = images.split(",".toRegex())
        return PosterImage(array[0], array[1])
    }

    @TypeConverter
    fun fromPosterImage(posterImage: PosterImage) : String {
        return posterImage.toString()
    }

}

class RatingConverter {

    @TypeConverter
    fun fromString(ratingAverage : String) = Rating(ratingAverage.toFloat())

    @TypeConverter
    fun fromRating(rating: Rating)= rating.toString()

}

class NetworkConverter {

    @TypeConverter
    fun fromString(networkName : String) = Network(networkName)

    @TypeConverter
    fun fromNetwork(network: Network) = network.toString()
}

class ScheduleConverter {

    @TypeConverter
    fun fromString(schedule : String) : Schedule {
        return Schedule("10:00", listOf("Mondey, Tuesday"))
    }


    @TypeConverter
    fun fromSchedule(schedule: Schedule) = schedule.toString()

}

class GenresConverter {

    @TypeConverter
    fun gettingListFromString(genres: String): List<String> {
        val list = mutableListOf<String>()

        genres.split(",".toRegex())
            .dropLastWhile { it.isEmpty() }
            .toTypedArray()
            .forEach {
                if (it.isNotEmpty()) {
                    list.add(it)
                }
            }

        return list
    }

    @TypeConverter
    fun writingStringFromList(list: List<String>): String {
        var genres = ""
        list.forEach { genres += it }
        return genres
    }
}