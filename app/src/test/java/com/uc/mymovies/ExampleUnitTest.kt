package com.uc.mymovies

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.uc.mymovies.dto.Movie
import com.uc.mymovies.service.MovieService
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private lateinit var firestore : FirebaseFirestore

    init {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }


    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun canRetrieveFromFirebase() {
//        var movieService: MovieService = MovieService()
//        movieService.fetchUserMovies("connorkeith")

        var movies = firestore?.collection("users").document("connorkeithck")
        movies.get().addOnSuccessListener { document ->
            if (document != null)
                print(document)
        }
    }

}
