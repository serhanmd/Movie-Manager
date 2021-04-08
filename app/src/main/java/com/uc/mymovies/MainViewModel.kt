package com.uc.mymovies
import androidx.lifecycle.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.uc.mymovies.dto.Movie
class MainViewModel : ViewModel() {
    var testMovieData: ArrayList<Movie> = ArrayList()
    var auth: FirebaseAuth = FirebaseAuth.getInstance()
    var db = FirebaseFirestore.getInstance()
    fun getTestData():ArrayList<Movie>{
        loadTestData()
        return testMovieData
    }
    fun loadTestData() {
        testMovieData.apply{
            add(Movie("Avatar", "Fantasy", "Jack Black", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b0/Avatar-Teaser-Poster.jpg/220px-Avatar-Teaser-Poster.jpg", "A movie about a blue person."))
            add(Movie("Joker", "Fantasy", "Jack Black", "https://m.media-amazon.com/images/M/MV5BNGVjNWI4ZGUtNzE0MS00YTJmLWE0ZDctN2ZiYTk2YmI3NTYyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg", "A movie about a blue person."))
            add(Movie("Spiderman", "Fantasy", "Jack Black", "https://upload.wikimedia.org/wikipedia/en/f/f9/Spider-Man_Homecoming_poster.jpg", "A movie about a blue person."))
            add(Movie("Thor", "Fantasy", "Jack Black", "https://images-na.ssl-images-amazon.com/images/I/91P1wWqX63L._SL1500_.jpg", "A movie about a blue person."))
            add(Movie("Avengers", "Fantasy", "Jack Black", "https://upload.wikimedia.org/wikipedia/en/8/8a/The_Avengers_%282012_film%29_poster.jpg", "A movie about a blue person."))
            add(Movie("Pokemon", "Fantasy", "Jack Black", "https://m.media-amazon.com/images/M/MV5BN2NkZjA0OWUtZDgyMy00MjIxLWJhZTEtYjdmYzVjZTQ3YWRiL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMzM4MjM0Nzg@._V1_UY1200_CR85,0,630,1200_AL_.jpg", "A movie about a blue person."))
            add(Movie("Iron Man", "Fantasy", "Jack Black", "https://upload.wikimedia.org/wikipedia/en/0/00/Iron_Man_poster.jpg", "A movie about a blue person."))
            add(Movie("The Boondock Saints", "Fantasy", "Jack Black", "https://m.media-amazon.com/images/M/MV5BYzVmMTdjOTYtOTJkYS00ZTg2LWExNTgtNzA1N2Y0MDgwYWFhXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg", "A movie about a blue person."))
            add(Movie("Training Day", "Fantasy", "Jack Black", "https://images-na.ssl-images-amazon.com/images/I/91EbJZH9JWL._SL1500_.jpg", "A movie about a blue person."))
            add( Movie("Smurfs", "Fantasy", "Jack Black", "https://upload.wikimedia.org/wikipedia/en/1/11/TheSmurfs2011Poster.jpg", "A movie about a blue person."))
        }

    }
}






