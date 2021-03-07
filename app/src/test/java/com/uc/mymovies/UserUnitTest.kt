package com.uc.mymovies

import com.uc.mymovies.dto.User
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UserUnitTest {
    @Test
    fun userDTO() {
        var user = User(123123124, "TheLegend27", "12345678", "NoobMaster69", "urm0m@gmail.com", null, null)
        assertTrue(user.id == 123123124)
        assertTrue(user.username == "TheLegend27")
        assertTrue(user.password == "12345678")
        assertTrue(user.profileName == "NoobMaster69")
        assertTrue(user.email == "urm0m@gmail.com")
    }

}
