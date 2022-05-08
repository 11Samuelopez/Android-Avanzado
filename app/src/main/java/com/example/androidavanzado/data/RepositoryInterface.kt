package com.example.androidavanzado.data

import android.graphics.Movie
import com.example.androidavanzado.data.remote.TvShowsPresentation
import com.example.androidavanzado.model.MoviePresentation
import com.example.androidavanzado.model.TvShowsNetwork

interface RepositoryInterface {
    suspend fun getRepositoryPopularMovies(): List<MoviePresentation>
    suspend fun getRepositoryPopularTvShows(): List<TvShowsPresentation>

}