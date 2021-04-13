package com.uc.mymovies.dto

import androidx.lifecycle.MutableLiveData

data class User(val uid: String, val email: String, val movies: List<Movie> = emptyList() ) {

    override fun toString(): String {
        return "$uid $email"
    }

}