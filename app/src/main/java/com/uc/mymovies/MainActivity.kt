package com.uc.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uc.mymovies.ui.main.MainViewModel

/**
 * MainActivity, responsible for UI/fragment functions
 */
class MainActivity : AppCompatActivity() {

    var mvm: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}