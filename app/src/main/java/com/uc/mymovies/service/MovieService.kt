package com.uc.mymovies.service
import androidx.lifecycle.MutableLiveData
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.uc.mymovies.dto.Movie
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
}