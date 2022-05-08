package com.example.androidavanzado.data.local

import androidx.room.Dao
import com.example.androidavanzado.model.MovieLocal
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val dao: MoviesDao) {


    fun getAllMovies(): List<MovieLocal>
        return dao.getAll()

    }

    fun insertMovie(movieLocal: MovieLocal) {
        Dao.insert(movieLocal)
    }


    fun deleteMovie(movieLocal: MovieLocal) {
        Dao.delete(movieLocal)
    }
}