package com.example.mytvmaze.database

import androidx.room.TypeConverter

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
