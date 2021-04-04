package com.uc.mymovies.dao

import androidx.room.Dao

@Dao
interface UserDAO {

    fun signIn()
    fun createAccount()
    // will further develop after authentication is created :)
}