package com.uc.mymovies.dto

data class UserMovieRating(val movie: Movie, var score: Int, var review: String, var isFavorite: Boolean) {


}