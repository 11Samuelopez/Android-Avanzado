package com.example.androidavanzado.data

import android.graphics.Movie
import androidx.contentpager.content.Query
import com.example.androidavanzado.data.remote.MovieAPI
import com.example.androidavanzado.data.remote.RemoteDataSourceInterface
import com.example.androidavanzado.model.Movie
import com.example.androidavanzado.model.MovieNetwork
import com.example.androidavanzado.model.PopularMovieResponse
import com.example.androidavanzado.model.TvShowsNetwork
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val api: MovieAPI
): RemoteDataSourceInterface {


    override suspend fun getRemotePopularMovies(): List<MovieNetwork> {
        val response = api.getPopularMovies()
        return response.results
    }

    override suspend fun getRemotePopularTvShows(): List<TvShowsNetwork> {
        val response = api.getPopularTvShows()
        return response.results
    }
}
