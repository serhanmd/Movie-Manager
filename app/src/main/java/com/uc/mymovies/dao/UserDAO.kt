package com.uc.mymovies.dao

interface UserDAO {

    fun signIn()
    fun createAccount()
    fun changeProfileName()
    fun changePassword()
    fun changeEmail()

}