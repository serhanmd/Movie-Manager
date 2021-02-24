package com.uc.mymovies

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import android.widget.ListAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.uc.mymovies.dto.Movie

class MainActivity : AppCompatActivity() {
    private var testMovieData: ArrayList<Movie> = ArrayList();

    private lateinit var firestore : FirebaseFirestore

    init {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    var main_activity = this;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var movie1: Movie = Movie("Avatar", "Fantasy", "Jack Black", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b0/Avatar-Teaser-Poster.jpg/220px-Avatar-Teaser-Poster.jpg", "A movie about a blue person.");
        var movie2: Movie = Movie("Joker", "Fantasy", "Jack Black", "https://m.media-amazon.com/images/M/MV5BNGVjNWI4ZGUtNzE0MS00YTJmLWE0ZDctN2ZiYTk2YmI3NTYyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg", "A movie about a blue person.");
        var movie3: Movie = Movie("Spiderman", "Fantasy", "Jack Black", "https://upload.wikimedia.org/wikipedia/en/f/f9/Spider-Man_Homecoming_poster.jpg", "A movie about a blue person.",);
        var movie4: Movie = Movie("Thor", "Fantasy", "Jack Black", "https://images-na.ssl-images-amazon.com/images/I/91P1wWqX63L._SL1500_.jpg", "A movie about a blue person.");
        var movie5: Movie = Movie("Avengers", "Fantasy", "Jack Black", "https://upload.wikimedia.org/wikipedia/en/8/8a/The_Avengers_%282012_film%29_poster.jpg", "A movie about a blue person.",);
        var movie6: Movie = Movie("Pokemon", "Fantasy", "Jack Black", "https://m.media-amazon.com/images/M/MV5BN2NkZjA0OWUtZDgyMy00MjIxLWJhZTEtYjdmYzVjZTQ3YWRiL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMzM4MjM0Nzg@._V1_UY1200_CR85,0,630,1200_AL_.jpg", "A movie about a blue person.");
        var movie7: Movie = Movie("Iron Man", "Fantasy", "Jack Black", "https://upload.wikimedia.org/wikipedia/en/0/00/Iron_Man_poster.jpg", "A movie about a blue person.");
        var movie8: Movie = Movie("The Boondock Saints", "Fantasy", "Jack Black", "https://m.media-amazon.com/images/M/MV5BYzVmMTdjOTYtOTJkYS00ZTg2LWExNTgtNzA1N2Y0MDgwYWFhXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg", "A movie about a blue person.");
        var movie9: Movie = Movie("Training Day", "Fantasy", "Jack Black", "https://images-na.ssl-images-amazon.com/images/I/91EbJZH9JWL._SL1500_.jpg", "A movie about a blue person.");
        var movie10: Movie = Movie("Smurfs", "Fantasy", "Jack Black", "https://upload.wikimedia.org/wikipedia/en/1/11/TheSmurfs2011Poster.jpg", "A movie about a blue person.");
        testMovieData.add(movie1);
        testMovieData.add(movie2);
        testMovieData.add(movie3);
        testMovieData.add(movie4);
        testMovieData.add(movie5);
        testMovieData.add(movie6);
        testMovieData.add(movie7);
        testMovieData.add(movie8);
        testMovieData.add(movie9);
        testMovieData.add(movie10);

        findViewById<ListView>(R.id.list_view).adapter = ListAdapter(main_activity, testMovieData);

        var searchButton = findViewById<ImageButton>(R.id.searchButton);

        var searchFilter = findViewById<EditText>(R.id.searchFilter);

        searchFilter.addTextChangedListener(object:TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }

            override fun afterTextChanged(s: Editable?) {
                if (s?.isNotEmpty() == true) {
                    var filteredQuery = testMovieData.filter { movie -> movie.title.toLowerCase().contains(s) };
                    findViewById<ListView>(R.id.list_view).adapter = ListAdapter(main_activity,
                        filteredQuery as ArrayList<Movie>
                    );
                }
            }
        })

        searchFilter.onFocusChangeListener = View.OnFocusChangeListener { view, b ->
            if (!b)
                hideSoftKeyboard(searchFilter);
        }

        searchButton.setOnClickListener({
            hideSoftKeyboard(searchFilter);
        });
    }

    fun Activity.hideSoftKeyboard(editText: EditText) {
        (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager).apply {
            hideSoftInputFromWindow(editText.windowToken, 0)
        }
    }
}