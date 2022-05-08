package com.example.androidavanzado.viewmodel

import android.util.Log
import android.util.LogPrinter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidavanzado.data.RemoteDataSource
import com.example.androidavanzado.data.Repository
import com.example.androidavanzado.data.local.LocalDataSource
import com.example.androidavanzado.data.remote.MovieAPI
import com.example.androidavanzado.model.Movie
import com.example.androidavanzado.model.MoviePresentation
import com.squareup.moshi.Moshi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: Repository

    ): ViewModel() {

    val data: MutableLiveData<List<MoviePresentation>> = MutableLiveData() val data: MutableLiveData<List<MoviePresentation>> = MutableLiveData()

     fun getPopularMovies(): {
        viewModelScope.launch {
           val movies = withContext(Dispatchers.IO) {
               repository.getPopularMovies()
           }

            data.postValue(movies)
        }
    }

    fun getMoviesReactivo(){
      data.postValue(listOf(
          "Batman 1",
          "Batman 2",
          "Batman 3",
      ).map { Movie(it) })
    }

    fun updateSoloStarWarsReactivo() {
        data.postValue(listOf(
            "Star Wars 1",
            "Star Wars 2",
            "Star Wars 3",
            "Star Wars 4",

            ).map { Movie(it) })
    }

    fun getMoviesCorrutina() {
        viewModelScope.launch { Dispatchers.IO
            delay(1000)
            data.postValue(listOf(
                "Star Wars 1",
                "Star Wars 2",
                "Star Wars 3",
                "Star Wars 4",

                ).map { Movie(it) })
        }

    }
    fun getMoviesCorrutinaResult() {
        viewModelScope.launch {
            Dispatchers.IO
            val result1 = getListMovies(0, 10)
            val result2 = getListMovies(10, 10)

            val resulWithContext = withContext(Dispatchers.IO) {
                delay(1000)
                "Hola"
            }

            val resultLaunch =launch {

            }

            resultLaunch.cancel()

            val resultAsync = async {
                delay(1000)
                "Hola"
            }

            resultAsync.await()
            Log.d("CORRRUTINAS", resulWithContext)
            Log.d("CORRRUTINAS", resultLaunch.toString())
            Log.d("CORRRUTINAS", resultAsync())

        }
    }

    private suspend fun getListMovies(start: Int, size: Int) : List<Movie> {
        val movies = listOf<Movie>()
        for (i in start ..(start + size)){
            movies.add(Movie("Title $i"))
        }

        return movies
    }

    fun getMoviesImperativo(): List<Movie>{
        return listOf(
            "Star Wars",
             "Batman",
            "Vengadores",
             "Star Wars",
             "Batman",
             "Vengadores",
             "Star Wars",
             "Batman",
             "Vengadores"
        ).map { Movie(it) }
    }

    fun deleteLocalDataBase() {
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            repository.deleteMovies()
        }
        getPopularMovies()
        getImagenesMovies()
    }
}