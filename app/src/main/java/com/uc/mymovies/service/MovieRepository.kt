package com.uc.mymovies.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.uc.mymovies.dto.Movie
import com.uc.mymovies.dao.MovieDAO
import kotlinx.coroutines.flow.Flow

object MovieRepository {

    private const val PAGE_SIZE = 50

    private val apiService = MovieDAO.create()

    fun getMovieListStream(): LiveData<PagingData<Movie>> {
        return Pager(
                config = PagingConfig(PAGE_SIZE),
                pagingSourceFactory = { MoviePagingSource(apiService)}
        ).liveData
    }

    fun getSearchMovieListStream(query: String) =
            Pager(
                    config = PagingConfig(PAGE_SIZE),
                    pagingSourceFactory = { SearchPagingSource(apiService, query)}
            ).liveData
}