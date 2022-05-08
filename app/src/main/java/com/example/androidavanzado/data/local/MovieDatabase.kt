package com.example.androidavanzado.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidavanzado.model.MovieLocal


@Database(entities = [MovieLocal::class], version = 1)
    abstract class MovieDatabase : RoomDatabase() {
        abstract fun MoviesDao(): MoviesDao
    abstract fun movieDao(): Any
}
}