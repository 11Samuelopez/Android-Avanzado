package com.example.androidavanzado.model

import com.squareup.moshi.Json

data class TvShowsNetwork(
    @Json(name = "name") val name: String = "",
    @Json(name = "popularity") val popularity: Double = 0.0,
    @Json(name = "poster_path") val posterPath: String = "",
    @Json(name = "genre_ids") val genreIds: List<Int> = listOf(),
    @Json(name = "vote_count") val genreCount: Int = 0,
    @Json(name = "original_language") val originalLenguage: String = "",
)

data class TvShowsNetwork(
    @Json(name = "file_path") val filePath: String = "",
    @Json(name = "aspect_ratio") val aspectRatio: String = "",
)