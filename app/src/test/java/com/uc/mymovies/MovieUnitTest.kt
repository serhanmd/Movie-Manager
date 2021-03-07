package com.uc.mymovies

import com.uc.mymovies.dto.Movie
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MovieUnitTest {
    @Test
    fun movieDTO() {
        var movie = Movie("The Matrix", "Action/Adventure", "Who Knows", "image.com", "A movie about people who never get hit by a bullet", false)
        assertTrue(movie.title == "The Matrix")
        assertTrue(movie.genre == "Action/Adventure")
        assertTrue(movie.director == "Who Knows")
        assertTrue(movie.image == "image.com")
        assertTrue(movie.synopsis == "A movie about people who never get hit by a bullet")
        assertTrue(movie.isFavorite.equals("false"))
    }

}
