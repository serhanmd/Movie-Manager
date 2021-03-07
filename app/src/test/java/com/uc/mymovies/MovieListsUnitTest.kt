package com.uc.mymovies

import com.uc.mymovies.dto.Movie
import com.uc.mymovies.dto.MoviesPlanToWatch
import com.uc.mymovies.dto.MoviesWatched
import com.uc.mymovies.dto.UserMovieRating
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MovieListsUnitTest {

    lateinit var moviesWatched: MoviesWatched
    lateinit var moviesPlanToWatch: MoviesPlanToWatch

    var movie1: Movie = Movie("Avatar", "Fantasy", "Jack Black", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b0/Avatar-Teaser-Poster.jpg/220px-Avatar-Teaser-Poster.jpg", "A movie about a blue person.")
    var movie2: Movie = Movie("Joker", "Fantasy", "Jack Black", "https://m.media-amazon.com/images/M/MV5BNGVjNWI4ZGUtNzE0MS00YTJmLWE0ZDctN2ZiYTk2YmI3NTYyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg", "A movie about a blue person.")
    var movie3: Movie = Movie("Spiderman", "Fantasy", "Jack Black", "https://upload.wikimedia.org/wikipedia/en/f/f9/Spider-Man_Homecoming_poster.jpg", "A movie about a blue person.",)

    var movie4: Movie = Movie("Thor", "Fantasy", "Jack Black", "https://images-na.ssl-images-amazon.com/images/I/91P1wWqX63L._SL1500_.jpg", "A movie about a blue person.")
    var movie5: Movie = Movie("Avengers", "Fantasy", "Jack Black", "https://upload.wikimedia.org/wikipedia/en/8/8a/The_Avengers_%282012_film%29_poster.jpg", "A movie about a blue person.",)
    var movie6: Movie = Movie("Pokemon", "Fantasy", "Jack Black", "https://m.media-amazon.com/images/M/MV5BN2NkZjA0OWUtZDgyMy00MjIxLWJhZTEtYjdmYzVjZTQ3YWRiL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMzM4MjM0Nzg@._V1_UY1200_CR85,0,630,1200_AL_.jpg", "A movie about a blue person.")

    var rating1: UserMovieRating = UserMovieRating(movie1, 3, "This movie stinks",false)
    var rating2: UserMovieRating = UserMovieRating(movie5, 10, "This movie is great",true)

    @Test
    fun moviesWatchedDTO() {
        givenMoviesWatched()
        assertTrue(moviesWatched.containsMovie(movie1))
        assertTrue(moviesWatched.containsMovie(movie2))
        assertTrue(moviesWatched.containsMovie(movie3))
        assertTrue(moviesWatched.containsRating(rating1))
        assertFalse(moviesWatched.containsRating(rating2))
    }

    @Test
    fun moviesPlanToWatchedDTO() {
        givenMoviesPlanToWatch()
        assertTrue(moviesPlanToWatch.contains(movie4))
        assertTrue(moviesPlanToWatch.contains(movie5))
        assertTrue(moviesPlanToWatch.contains(movie6))

    }

    private fun givenMoviesWatched(){
        moviesWatched = MoviesWatched()
        with(moviesWatched)
        {
            addMovie(movie1)
            addMovie(movie2)
            addMovie(movie3)
            addRating(rating1)
            addRating(rating2)
        }
    }

    private fun givenMoviesPlanToWatch(){
        moviesPlanToWatch = MoviesPlanToWatch()
        with(moviesPlanToWatch)
        {
            addMovie(movie4)
            addMovie(movie5)
            addMovie(movie6)
        }
    }





}