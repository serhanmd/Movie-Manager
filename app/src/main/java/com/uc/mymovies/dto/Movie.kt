package com.uc.mymovies.dto

data class Movie(val title: String, val genre: String, val director: String, val image: String, val synopsis: String, var isFavorite: Boolean=false) {

    override fun toString(): String {
        return "$title $genre $director $image $synopsis $isFavorite"
    }

}