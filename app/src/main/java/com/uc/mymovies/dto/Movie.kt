package com.uc.mymovies.dto

/**
 * Data class representing a movie object.
 *
 * @param title
 * @param genre
 * @param director
 * @param image
 * @param synopsis
 * @param isFavorite
 */
data class Movie(val title: String,
                 val genre: String,
                 val director: String,
                 val image: String,
                 val synopsis: String,
                 var isFavorite: Boolean=false) {

    override fun toString(): String {
        return "$title $genre $director $image $synopsis $isFavorite"
    }
}