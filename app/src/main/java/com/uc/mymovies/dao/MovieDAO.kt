package com.uc.mymovies.dao

import androidx.room.Dao

@Dao
interface MovieDAO {

    fun getAllMovies()
    fun getMovieById()
    fun getMovieByTitle()
    fun getMoviesByGenre()
    fun getMoviesByDirector()

}