package com.uc.mymovies.dto

data class MoviesPlanToWatch(var planToWatch : MutableSet<Movie>? = null) {

    fun addMovie(m: Movie)
    {
        planToWatch?.add(m)
    }

    fun contains(m: Movie): Boolean{
        planToWatch?.forEach { Movie -> if(Movie == m) {return true} }
        return false
    }

}