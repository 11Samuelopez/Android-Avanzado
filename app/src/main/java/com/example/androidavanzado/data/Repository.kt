package com.example.androidavanzado.data

import com.example.androidavanzado.data.local.LocalDataSource
import com.example.androidavanzado.data.remote.MovieAPI
import com.example.androidavanzado.data.remote.RemoteDataSourceInterface
import com.example.androidavanzado.data.remote.TvShowsPresentation
import com.example.androidavanzado.model.Movie
import com.example.androidavanzado.model.MovieLocal
import com.example.androidavanzado.model.MovieNetwork
import com.example.androidavanzado.model.MoviePresentation
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote = RemoteDataSource,
    private val local = LocalDataSource,
    private val networkToLocalMapper: NetworkToLocalMapper,
    private val localToPresentationMapper: LocalToPresentationMapper,
): RepositoryInterface {


    override suspend fun getPopularMovies(): List<MoviePresentation>{
            val moviesLocal = local.getAllMovies()

            if (localMovies.isEmpty()){
                val remoteMovies = remote.getRemotePopularMovies()

                remoteMovies.forEach{
                    local.insertMovie(networkToLocalMapper.mapToLocal(it))

                }
            }

            return local.getAllMovies().map { localToPresentationMapper.mapToLocal(it) }

    }


    override suspend fun getRepositoryPopularTvShows(): List<TvShowsPresentation> {
    }(): List<MoviePresentation> {

        val remoteTvShows = remote.getRemotePopularTvShows()

        return remoteTvShows.map { it.toPresentation() }

    }

    fun deleteMovies() {
        local.getAllMovies().forEach {
            local.deleteMovie(it)
        }
    }

    override suspend fun getRepositoryPopularMovies(): List<MoviePresentation> {
    }


}