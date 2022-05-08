package com.example.androidavanzado.data.di

import com.example.androidavanzado.data.RemoteDataSource
import com.example.androidavanzado.data.local.MovieDatabase
import com.example.androidavanzado.data.local.MoviesDao
import com.example.androidavanzado.data.remote.MovieAPI
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@Module
@InstallIn(SingletonComponent::class)

    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(
             HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                     level = HttpLoggingInterceptor.Level.BODY
             }.AddInterceptor { chain ->
                 val request = chain.request()
                 val originalUrl = request.url


                 val newUrl = originalUrl.newBuilder().addQueryParameter( "api_key" ,"20985cf66e1756b5eea015b67a341389" ).build()
                 val newRequest = request.newBuilder().url(newUrl).build()

                chain.proced(newRequest)

             }
                 .build()
    }


    @Provides
    fun providesMoshi(): Moshi {
        return  Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
             ).build()
    }




    @Provides
    fun providesRetrofit(OkHttpClient: OkHttpClient, moshi:Moshi): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
             .client(okHttpCLient)
              .addCallAdapterFactory(MoshiConverterFactory.create(moshi))
             .build()
    }


    @Provides
    fun providesMovieAPI(retrofit: Retrofit): MovieAPI
    {
       return retrofit.create(MovieAPI::class.java)
    }

    @Provides
    fun providesMovieDatabase(@ApplicationContext: Context): MovieDatabase {
    }
return Room.databaseBuilder(
            context,
            MovieDatabase::class.java ,  "themoviedb.database"
        ).build()
    }

    @Provides
    fun providesMovieDao(mocieDatabase: MovieDatabase): MoviesDao(
        return movieDatabase.movieDao()
    )

}