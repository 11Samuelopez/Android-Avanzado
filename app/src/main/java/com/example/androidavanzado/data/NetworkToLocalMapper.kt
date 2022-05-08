package com.example.androidavanzado.data

import com.example.androidavanzado.model.MovieLocal
import com.example.androidavanzado.model.MovieNetwork
import javax.inject.Inject


class NetworkToLocalMapper @Inject constructor(){

    fun mapToLocal(movieNetwork: MovieNetwork): MovieLocal {
        return MovieLocal(
                        uid = null,
                        title = movieNetwork.title,
                         popularity = movieNetwork.popularity,
                         posterPath = movieNetwork.posterPath,
                        voteCount = movieNetwork.voteCount,
                        originalLenguage = movieNetwork.originalLenguage

        )
    }


}