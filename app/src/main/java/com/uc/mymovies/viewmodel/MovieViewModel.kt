package com.uc.mymovies.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.uc.mymovies.dto.Movie
import com.uc.mymovies.repository.MovieRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MovieViewModel @ViewModelInject constructor(
    @Assisted state: SavedStateHandle
) : ViewModel(){

    var auth: FirebaseAuth = FirebaseAuth.getInstance()
    var db = FirebaseFirestore.getInstance()

    private val searchQuery = MutableLiveData("")

    val movies: LiveData<PagingData<Movie>> =
        searchQuery.switchMap { query ->
            if(query.isNotEmpty()) {
                MovieRepository.getSearchMovieListStream(query).cachedIn(viewModelScope)
            } else {
                MovieRepository.getMovieListStream().cachedIn(viewModelScope)
            }
        }

    fun setSearchQuery(query: String) {
        searchQuery.value = query
    }
}