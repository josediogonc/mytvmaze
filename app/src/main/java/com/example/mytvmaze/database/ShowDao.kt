package com.example.mytvmaze.database

import androidx.room.*
import com.example.mytvmaze.tvmaze.shows.model.Show

@Dao
interface ShowDao {

    @Query("SELECT * FROM show")
    fun all() : List<Show>

    @Query("SELECT * FROM show WHERE id==:id")
    fun get(id : Int) : Show

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun add(vararg show : Show)

    @Update
    fun update(vararg show : Show)

}
