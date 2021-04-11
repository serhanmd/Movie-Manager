package com.uc.mymovies.dto

import com.google.gson.annotations.SerializedName

data class Movie(@SerializedName("title") var title: String,
                 @SerializedName("poster_path") var imagePath: String,
                 @SerializedName("overview") var overview: String,
                 var isFavorite: Boolean=false) {

    override fun toString(): String {
        return "$title  $imagePath $overview $isFavorite"
    }
}