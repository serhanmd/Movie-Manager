package com.uc.mymovies

import com.uc.mymovies.dto.Movie
import org.junit.Test

import org.junit.Assert.*


class MovieUnitTest {
    lateinit var movie : Movie

    @Test
    fun movieDTO_MaintainsState() {
        givenMovieDTO()
        whenMovieDTO_Initialized()
        thenMovie_MaintainsState()


    }

    private fun thenMovie_MaintainsState() {
        assertTrue(movie.title.equals("The Matrix"))
        assertTrue(movie.genre.equals("Action/Adventure"))
        assertTrue(movie.director.equals("Who Knows"))
        assertTrue(movie.image.equals("image.com"))
        assertTrue(movie.synopsis.equals(("A movie about people who never get hit by a bullet")))
        assertTrue(movie.isFavorite.equals((false)))

    }

    private fun whenMovieDTO_Initialized() {
        movie = Movie("The Matrix", "Action/Adventure", "Who Knows", "image.com", "A movie about people who never get hit by a bullet", false)

    }


    private fun givenMovieDTO(){
        movie



    }



}
