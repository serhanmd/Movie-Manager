package com.uc.mymovies.dto

data class MoviesWatched(var moviesWatched : MutableSet<Movie>? = null, var moviesRated : MutableSet<UserMovieRating>? = null){

    fun addMovie(m: Movie)
    {
        moviesWatched?.add(m)
    }

    fun addRating(u: UserMovieRating)
    {
        if(moviesWatched?.contains(u.movie) == true){
            moviesRated?.add(u)
        } else {
            //Some kind of error message to the user
        }

    }

    fun containsMovie(m: Movie): Boolean{
        moviesWatched?.forEach { Movie -> if(Movie == m) {return true} }
        return false
    }

    fun containsRating(u: UserMovieRating): Boolean{
        moviesRated?.forEach { UserMovieRating -> if(UserMovieRating == u) {return true} }
        return false
    }



}