package com.uc.mymovies.dto

data class User(val id: Int, val username: String, val password: String, val profileName: String, val email: String ) {
    override fun toString(): String {
        return "$id $username $password $profileName $email"
    }
}