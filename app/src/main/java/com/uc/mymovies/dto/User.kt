package com.uc.mymovies.dto

/**
 * Data class representing a user object.
 *
 * Stores the username, password, profile name, and email of a user.
 * @param id
 * @param username
 * @param password
 * @param profileName
 * @param email
 */
data class User(val id: Int,
                val username: String,
                val password: String,
                val profileName: String,
                val email: String ) {

    override fun toString(): String {
        return "$id $username $password $profileName $email"
    }

}