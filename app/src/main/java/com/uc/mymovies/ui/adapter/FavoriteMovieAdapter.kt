package com.example.movielist.ui.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.uc.mymovies.databinding.MovieItemBinding
import com.uc.mymovies.dto.Movie
class FavoriteMovieAdapter(
    val onClick: (Movie) -> Unit
): ListAdapter<Movie, FavoriteMovieAdapter.FavoriteMovieVH>(DiffUtils) {
    inner class FavoriteMovieVH(val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {
                tvMoviesTitle.text = movie.original_title
                //todo create MovieAdapter
                rlMovie.setOnClickListener {
                    onClick(movie)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieVH {
        val binding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FavoriteMovieVH(binding)
    }
    override fun onBindViewHolder(holder: FavoriteMovieVH, position: Int) {
        holder.bind(getItem(position))
    }
    companion object{
        const val IMAGE_DOMAIN = "https://image.tmdb.org/t/p/w500/"
        private val DiffUtils = object: DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }
}