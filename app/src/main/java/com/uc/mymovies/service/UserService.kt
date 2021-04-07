package com.uc.mymovies.service

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.uc.mymovies.dto.User

class UserService {

    private lateinit var firestore : FirebaseFirestore

    init {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }


    fun createNewUser(user: User) {
        // called when a new user registers with firestore, this adds them to our collection as well
            firestore?.collection("users").document().set(user).addOnSuccessListener {
                Log.d("Firebase", "New user saved!")
            }

    }

}