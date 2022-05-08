package com.example.androidavanzado.view.movies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidavanzado.data.Repository
import com.example.androidavanzado.model.MoviePresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: Repository

): ViewModel() {

    val data: MutableLiveData<List<MoviePresentation>> = MutableLiveData()
    val data: MutableLiveData<List<MoviePresentation>> = MutableLiveData()

    fun getPopularMovies(): {
        viewModelScope.launch {
            val movies = withContext(Dispatchers.IO) {
                repository.getPopularMovies()
            }

            data.postValue(movies)
        }
    }
}