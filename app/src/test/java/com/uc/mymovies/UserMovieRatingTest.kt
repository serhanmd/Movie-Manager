package com.uc.mymovies

import com.uc.mymovies.dto.Movie
import com.uc.mymovies.dto.UserMovieRating
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UserMovieRatingTest {


    @Test
    fun movieDTO() {

        var movie1: Movie = Movie("Avatar", "Fantasy", "Jack Black",
            "https://upload.wikimedia.org/wikipedia/en/thumb/b/b0/Avatar-Teaser-Poster.jpg/220px-Avatar-Teaser-Poster.jpg", "A movie about a blue person.")

        var rating1: UserMovieRating = UserMovieRating(movie1, 3, "This movie stinks",false)
        assertTrue(rating1.movie == movie1)
        assertTrue(rating1.score == 3)
        assertTrue(rating1.review == "This movie stinks")
        assertTrue(rating1.isFavorite == false)

    }

}