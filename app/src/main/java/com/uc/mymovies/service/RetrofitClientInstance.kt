package com.uc.mymovies.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {
// for reference later https://developers.themoviedb.org/3/movies/get-now-playing
    private val API_KEY = "994b1e7365e576a4a3602cb07f81dbf0"
    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://api.themoviedb.org/3/movie/upcoming?api_key=994b1e7365e576a4a3602cb07f81dbf0&language=en-US&page=1"
    private val REQUEST = BASE_URL + API_KEY

    val retrofitInstance : Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit
        }


}