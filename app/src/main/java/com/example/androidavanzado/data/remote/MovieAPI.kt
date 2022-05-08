package com.example.androidavanzado.data.remote

import com.example.androidavanzado.model.PopularMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieAPI {
    @GET ( "/3/movie/popular")
    suspend fun getPopularMovies(): PopularMovieResponse

    @GET ( "/3/movies/get-movie-images")
    suspend fun getPopularMovies(): PopularMovieResponse


    @GET ( "/3/tv/popular")
    suspend fun getPopularTvShows(): PopularTvShowsResponse

    @GET ( "/3/tv/get-movie-images")
    suspend fun getPopularTvShows(): PopularTvShowsResponse
}