package com.example.androidavanzado.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "movies")
data class MovieOriginal(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "uid") val uid: Int? = -1,
    @ColumnInfo(name = "title")@Json(name = "title") val title: String = "",
    @ColumnInfo(name = "popularity")@Json(name = "popularity") val popularity: Double = 0.0,
    @ColumnInfo(name = "poster_path")@Json(name = "poster_path") val posterPath: String = "",
    @ColumnInfo(name = "genre_ids") @Json(name = "genre_ids") val genreIds: List<Int> = listOf(),
    @ColumnInfo(name = "vote_count") @Json(name = "vote_count") val genreCount: Int = 0,
    @ColumnInfo(name = "original_language") @Json(name = "original_language") val originalLenguage: String = "",)

 data class MovieNetwork(
        @Json(name = "title") val title: String = "",
        @Json(name = "popularity") val popularity: Double = 0.0,
        @Json(name = "poster_path") val posterPath: String = "",
        @Json(name = "genre_ids") val genreIds: List<Int> = listOf(),
        @Json(name = "vote_count") val genreCount: Int = 0,0
        @Json(name = "original_language") val originalLenguage: String = "",
)

data class MovieNetwork(
    @Json(name = "file_path") val filePath: String = "",
    @Json(name = "aspect_ratio") val aspectRatio: String = "",
)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(uid)
        parcel.writeString(title)
        parcel.writeDouble(popularity)
        parcel.writeString(posterPath)
        parcel.writeInt(genreCount)
        parcel.writeString(originalLenguage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieOriginal> {
        override fun createFromParcel(parcel: Parcel): MovieOriginal {
            return MovieOriginal(parcel)
        }

        override fun newArray(size: Int): Array<MovieOriginal?> {
            return arrayOfNulls(size)
        }
    }
}

@Json(name = "title") val title: String = "",
    @Json(name = "popularity") val popularity: Double = 0.0,
    @Json(name = "poster_path") val posterPath: String = "",
    @Json(name = "genre_ids") val genreIds: List<Int> = listOf(),
    @Json(name = "original_language") val originalLenguage: String = ""

)

@Entity(tableName = "movies")
data class MovieLocal(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "uid") val uid: Int? ,
    @ColumnInfo(name = "title") val title: String = "",
    @ColumnInfo(name = "popularity") val popularity: Double = 0.0,
    @ColumnInfo(name = "poster_path") val posterPath: String = "",
    @ColumnInfo(name = "genre_ids") val genreIds: List<Int> = listOf(),
    @ColumnInfo(name = "vote_count") val genreCount: Int = 0,
    @ColumnInfo(name = "original_language") val originalLenguage: String = "",

    )
data class MoviePresentation(
    val title: String = "",
    val posterPath: String = "",
    val genreIds: List<Int> = listOf(),

}


