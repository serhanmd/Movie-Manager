package com.uc.mymovies.service

import androidx.lifecycle.MutableLiveData
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.uc.mymovies.dao.MovieDAO
import com.uc.mymovies.dto.Movie
import retrofit2.Callback

class MovieService {

//    var firebase = FirebaseInstance.firebaseInstance
    private lateinit var firestore : FirebaseFirestore

    init {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    fun fetchUserMovies(username: String) : MutableLiveData<ArrayList<Movie>> {
        var movies = firestore?.collection("users").document(username)
        movies.get().addOnSuccessListener { document ->
            if (document != null)
                print(document)
        }

        return MutableLiveData()
    }

//    fun fetchUpcomingMovies() : MutableLiveData<ArrayList<Movie>> {
//        var movies = MutableLiveData<ArrayList<Movie>>()
//        var request = RetrofitClientInstance.retrofitInstance?.create(MovieDAO::class.java)
//        val call = request?.fetchUpcomingMovies()
////        call?.enqueue(object: Callback<ArrayList<Movie>>) {
////            // TODO: API call for upcoming movies :)
////        }
//    }

}