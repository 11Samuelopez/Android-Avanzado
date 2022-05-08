package com.example.androidavanzado.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidavanzado.model.MovieLocal

class MoviesDao {
}@Dao
interface MoviesDao {
    @Query("SELECT * FROM movies")
    fun getAll(): List<MovieLocal>

    @Query("SELECT * FROM movies WHERE uid = :id"
    fun getMovies(Id: Int): MovieLocal

    @Insert
    fun insert(movieLocal: MovieLocal)

    @Delete
    fun delete(movieLocal: MovieLocal)

}
