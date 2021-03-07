package com.uc.mymovies.dto

data class User(val id: Int, val username: String, var password: String, var profileName: String, var email: String, var moviesWatched: MoviesWatched?, var moviesPlanToWatch: MoviesPlanToWatch?) {
}