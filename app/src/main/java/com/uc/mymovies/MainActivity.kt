package com.uc.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
       var result = movieService.fetchUserMovies("connorkeith")
        Log.d("TEST-LOG: ", result.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}