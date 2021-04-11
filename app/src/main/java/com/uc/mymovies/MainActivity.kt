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

    private fun fetchMovies(user: String) {
       var result = movieService.fetchUserMovies(user)
        Log.d("TEST-LOG: ", result.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        var user = intent.getStringExtra("user")
        super.onCreate(savedInstanceState)
        if (user != null) {
           var movies = fetchMovies(user)
            Log.d("Movies grabbed: ", movies.toString())
        } else {
            // error message stuff
        }
        setContentView(R.layout.activity_main)
    }
}