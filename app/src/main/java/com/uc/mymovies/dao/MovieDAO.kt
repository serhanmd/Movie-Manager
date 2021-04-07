package com.uc.mymovies.dao

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import com.uc.mymovies.dto.Movie

@Dao
interface MovieDAO {
    fun getAllMovies() : MutableLiveData<ArrayList<Movie>>
    fun getMovieById() : Movie
    fun getMovieByTitle() : Movie
}