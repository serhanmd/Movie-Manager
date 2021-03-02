package com.uc.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListAdapter
import android.widget.ListView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.uc.mymovies.service.MovieService

class MainActivity : AppCompatActivity() {

    var movieService: MovieService = MovieService()

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        movieService.fetchUserMovies("connorkeith")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchMovies()

    }
}