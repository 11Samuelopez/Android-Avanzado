package com.example.androidavanzado.viewmodel

import com.example.androidavanzado.data.RemoteDataSource
import com.example.androidavanzado.data.Repository
import com.example.androidavanzado.data.local.LocalDataSource
import com.example.androidavanzado.data.remote.MovieAPI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

interface MovieViewModelInterface {
    fun getViewModelPopularMovies()
}









