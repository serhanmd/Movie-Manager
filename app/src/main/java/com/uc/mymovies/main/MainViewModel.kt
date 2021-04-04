package com.uc.mymovies.main
import android.util.Log
import androidx.lifecycle.ViewModel
import com.uc.mymovies.service.MovieService


class MainViewModel : ViewModel() {

    var movieService: MovieService = MovieService()

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        var result = movieService.fetchUserMovies("connorkeith")
        Log.d("TEST-LOG: ", result.toString())
    }

}