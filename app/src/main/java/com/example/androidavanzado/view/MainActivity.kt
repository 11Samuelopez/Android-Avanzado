package com.example.androidavanzado.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidavanzado.ActivityMain2Binding
import com.example.androidavanzado.viewmodel.MovieViewModel
import com.example.androidavanzado.R
import com.example.androidavanzado.data.RemoteDataSource
import com.example.androidavanzado.data.Repository
import com.example.androidavanzado.data.local.LocalDataSource
import com.example.androidavanzado.data.remote.MovieAPI
import com.example.androidavanzado.view.movies.MoviesFragment
import com.example.androidavanzado.view.tvshows.TvShowsFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    private val okHttpClient = OkHttpClient.Builder().addInterceptor()

    HttpLoginInterceptor(HttpLoginInterceptor.Logger.DEFAULT).apply {
        level = HttpLoginInterceptor.Level.BODY
    }
    ).build()

    private val Moshi = Moshi.Builder()
        .add(kotlinJasonAdapterFAactory())
        .build()

    private var retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(Moshi))
        .build()

    private var api: MovieAPI = retrofit.create(MovieAPI ::class.java)

    private val remote = RemoteDataSource()
    private val local = LocalDataSource()
    private val repository = Repository(remote, local)

    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter = MovieAdapter(ArrayList())


        binding.myRecycler.adapter = adapter
        binding.myRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        GlobalScope.launch(Dispatchers.IO) {
            while (true) {

                delay(3000)
                ViewModel.getMoviesReactivo()
                delay(3000)
                viewModel.updateSoloStarWarsReactivo()
            }
        }


        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, MoviesFragment.newInstance())
            .commit()


    binding.bottomNavBar.setOnItemSelectedListener {
        when(it.itemId){
            R.id.page_1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(binding.fragmentContainer.id, MoviesFragment.newInstance())
                    .commit()
                true
        }
            R.id.page_2 -> {

                supportFragmentManager.beginTransaction()
                    .replace(binding.fragmentContainer.id, TvShowsFragment.newInstance())
                    .commit()

                true
        }
            else -> {
                true
            }
        }

    }

}