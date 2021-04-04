package com.uc.mymovies.service

import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.uc.mymovies.dto.User

class UserService {
    private var firestore: FirebaseFirestore

    init {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    fun fetchUsers(username: String): MutableLiveData<ArrayList<User>> {
        //This line will probably have to be modified, I can't see your guys' firestore so I don't know your structure for it
        var users = firestore?.collection("users").document(username)
        users.get().addOnSuccessListener { document ->
            if (document != null)
                print(document)
        }

        return MutableLiveData()
    }
}