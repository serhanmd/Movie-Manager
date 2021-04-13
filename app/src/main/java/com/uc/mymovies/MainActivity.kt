package com.uc.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

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
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
  var movieService: MovieService = MovieService()

    private fun fetchMovies(user: String) {
       var result = movieService.fetchUserMovies(user)
        Log.d("TEST-LOG: ", result.toString())
    }
}