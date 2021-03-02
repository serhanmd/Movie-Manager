package com.uc.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private val name = arrayOf("Avatar", "Joker", "Spiderman", "Thor", "Avengers", "Pokemon", "Iron Man", "The Boondock Saints", "Training Day", "Smurfs")

    private val image = arrayOf(R.drawable.avatar, R.drawable.joker, R.drawable.spiderman, R.drawable.thor, R.drawable.avengers, R.drawable.pokemon, R.drawable.ironman, R.drawable.boondocksaints,
            R.drawable.trainingday, R.drawable.smurfs)

    private val isFavorite = arrayOf(false, false, false, false, false, false, false, false, false, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ListView>(R.id.list_view).adapter = ListAdapter(this, image, name, isFavorite)
    }
}