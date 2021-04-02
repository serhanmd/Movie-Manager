package com.uc.mymovies.dao

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import com.uc.mymovies.dto.Movie
import retrofit2.Call
import retrofit2.http.GET

@Dao
interface MovieDAO {

    @GET("movie/upcoming?api_key=994b1e7365e576a4a3602cb07f81dbf0&language=en-US&page=1")
    fun fetchUpcomingMovies() : Call<ArrayList<Movie>>

}