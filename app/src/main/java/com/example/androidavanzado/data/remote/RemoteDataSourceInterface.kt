package com.example.androidavanzado.data.remote

import android.graphics.Movie
import com.example.androidavanzado.model.MovieNetwork
import com.example.androidavanzado.model.TvShowsNetwork

interface RemoteDataSourceInterface {
    suspend fun getRemotePopularMovies(): List<MovieNetwork>
    suspend fun getRemotePopularTvShows(): List<TvShowsNetwork>

}