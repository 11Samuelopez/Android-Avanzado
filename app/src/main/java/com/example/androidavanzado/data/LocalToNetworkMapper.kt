package com.example.androidavanzado.data

import com.example.androidavanzado.data.remote.movieNetwork
import com.example.androidavanzado.model.MovieLocal
import com.example.androidavanzado.model.MovieNetwork
import javax.inject.Inject


class LocalToNetworkMapper @Inject constructor(){

    fun mapToLocal(movieLocal: MovieLocal): MovieLocal {
        return MovieLocal(title = MovieNetwork.title,
                         popularity = movieNetwork.popularity,
                         posterPath = movieNetwork.posterPath,
                        voteCount = movieNetwork.voteCount,
                        originalLenguage = movieNetwork.originalLenguage

        )
    }


}