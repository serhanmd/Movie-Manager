package com.uc.mymovies

import com.uc.mymovies.dto.User
import org.junit.Test

import org.junit.Assert.*


class UserUnitTest {
    lateinit var user : User

    @Test
    fun userDTO_MaintainsState() {
        givenUserDTO()
        whenUserDTO_Initialized()
        thenUser_MaintainsState()


    }

    private fun thenUser_MaintainsState() {
        assertTrue(user.id.equals(123456))
        assertTrue(user.username.equals("TheLegend27"))
        assertTrue(user.password.equals("P@ssw0rd"))
        assertTrue(user.profileName.equals("TheLegend28"))
        assertTrue(user.email.equals("eliteHaxx0r@gmail.com"))



    }

    private fun whenUserDTO_Initialized() {
        user = User(123456, "TheLegend27", "P@ssw0rd", "TheLegend28","eliteHaxx0r@gmail.com")

    }


    private fun givenUserDTO(){
        user



    }



}
