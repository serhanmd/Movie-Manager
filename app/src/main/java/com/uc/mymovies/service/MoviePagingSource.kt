package com.uc.mymovies.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.uc.mymovies.BuildConfig
import com.uc.mymovies.dto.Movie
import com.uc.mymovies.dao.MovieDAO
import java.lang.Exception

class MoviePagingSource(
        private val service: MovieDAO
): PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try{
            val page = params.key?: 1
            val repoResponse = service.getUpcomingMovies(BuildConfig.TMDB_API_KEY, page)
            val repoItems = repoResponse.results
            val prevKey = if(page > 1) page - 1 else null
            val nextKey = if(repoItems.isNotEmpty()) page + 1 else null
            LoadResult.Page(repoItems, prevKey, nextKey)
        }catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? = null
}

class SearchPagingSource(
        private val service: MovieDAO,
        private val query: String
): PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try{
            val page = params.key?: 1
            val repoResponse = service.searchMovieByQuery(BuildConfig.TMDB_API_KEY, query)
            val repoItems = repoResponse.results
            LoadResult.Page(repoItems, null, null)
        }catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}