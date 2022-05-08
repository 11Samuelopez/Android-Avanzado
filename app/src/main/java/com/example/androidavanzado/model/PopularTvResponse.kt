package com.example.androidavanzado.model

import com.squareup.moshi.Json

class class PopularMovieResponse (
    @Json(name = "total_result") val total_Result : Int?,
    @Json(name = "results") val results = List<TvShowsNetwork>

)


