package com.uc.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListAdapter
import android.widget.ListView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.uc.mymovies.main.MainFragment
import com.uc.mymovies.main.MainViewModel
import com.uc.mymovies.service.MovieService

class MainActivity : AppCompatActivity() {
    // create fragment for each layout in a new package
     private lateinit var mainFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // mainFragment = MainFragment.newInstance()
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        savedInstanceState?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, mainFragment)
                .commitNow()
        }
    }
}