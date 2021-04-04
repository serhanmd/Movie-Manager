package com.uc.mymovies.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.uc.mymovies.service.MovieService
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.uc.mymovies.dto.Movie


/**
 * MVM class. Prepares data for the UI.
 *
 * Contains methods for saving to and accessing the Firebase database
 */
class MainViewModel : ViewModel() {
    var movieService: MovieService = MovieService()
    private var firestore : FirebaseFirestore

    init {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    fun fetchUserMovies(username: String) : MutableLiveData<ArrayList<Movie>> {
        val movies = firestore.collection("users").document(username)
        movies.get().addOnSuccessListener { document ->
            if (document != null)
                print(document)
        }

        return MutableLiveData()
    }

    fun fetchMovies() {
        val result = fetchUserMovies("connorkeith")
        Log.d("TEST-LOG: ", result.toString())
    }
}