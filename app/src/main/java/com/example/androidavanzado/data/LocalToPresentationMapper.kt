package com.example.androidavanzado.data

import com.example.androidavanzado.data.remote.movieNetwork
import com.example.androidavanzado.model.MovieLocal
import com.example.androidavanzado.model.MovieNetwork
import com.example.androidavanzado.model.MoviePresentation
import javax.inject.Inject


class LocalToNetworkMapper @Inject constructor() {

    fun mapToLocal(movieLocal: MovieLocal): MoviePresentation {
        return MovieLocal(title = movieNetwork.title,
                         posterPath = movieNetwork.posterPath,
                        voteCount = movieNetwork.voteCount,
                        originalLenguage = movieNetwork.originalLenguage

        )
    }
}

