package com.uc.mymovies.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.uc.mymovies.R
import com.uc.mymovies.databinding.FragmentDetailsMovieBinding
import com.uc.mymovies.dto.Movie
import com.uc.mymovies.utils.hide
import com.uc.mymovies.utils.show
import com.uc.mymovies.utils.showToast
import com.uc.mymovies.viewmodel.MovieViewModel


class DetailsMovieFragment: Fragment(R.layout.fragment_details_movie) {

    private lateinit var binding: FragmentDetailsMovieBinding
    private val args by navArgs<DetailsMovieFragmentArgs>()
    private val movieViewModel by activityViewModels<MovieViewModel>()

    companion object{
        const val IMAGE_DOMAIN = "https://image.tmdb.org/t/p/w500/"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentDetailsMovieBinding.bind(view)

        binding.toolbar.apply {
            setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
            setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }
        val movie = args.movie

        checkFavoriteMovie(movie)

        binding.btnAddToFavorite.setOnClickListener {
            if(movieViewModel.auth.currentUser == null) {
                "Please login first".showToast(requireContext())
                findNavController().navigate(R.id.loginFragment)
            } else {
                // ADD FAVORITE MOVIE INTO FIREBASE
                if (movie != null) {
                    // Use logged in user's email as collection's key
                    movieViewModel.db.collection(movieViewModel.auth.currentUser.email)
                            .document(movie.id.toString())
                            .set(movie)
                            .addOnSuccessListener {
                                "Added to Favorite".showToast(requireContext())
                                setFavoriteMovieUI()
                            }
                            .addOnFailureListener {
                                it.showToast(requireContext())
                            }
                }
            }
        }

        binding.btnRemoveFromFavorite.setOnClickListener {
            if(movieViewModel.auth.currentUser == null) {
                "Please login first".showToast(requireContext())
                findNavController().navigate(R.id.loginFragment)
            } else {
                // REMOVE FAVORITE MOVIE FROM FIREBASE
                if (movie != null) {
                    // Use logged in user's email as collection's key
                    movieViewModel.db.collection(movieViewModel.auth.currentUser.email)
                            .document(movie.id.toString())
                            .delete()
                            .addOnSuccessListener {
                                "Removed from Favorite".showToast(requireContext())
                                setNormalMovieUI()
                            }
                            .addOnFailureListener {
                                it.showToast(requireContext())
                            }
                }
            }
        }

        // Hide favorite button if coming from favorite movielist
        if(args.isFromFavorite) {
            binding.btnAddToFavorite.hide()
        } else binding.btnAddToFavorite.show()
    }

    private fun initView(movie: Movie?) {
        binding.progressBar.hide()
        movie?.let {
            binding.imageDetail.load(IMAGE_DOMAIN + it.backdrop_path)
            binding.tvRealName.text = it.original_title
            binding.tvReleaseDate.text = it.release_date

            binding.tvOverview.text = it.overview
            binding.rbRating.rating = getRatingStar(it)
        }
    }

    private fun checkFavoriteMovie(movie: Movie?) {
        if(movieViewModel.auth.currentUser == null) {
            setNormalMovieUI()
            initView(movie)
        } else {
            val collectRef = movieViewModel.db.collection(movieViewModel.auth.currentUser.email)
            collectRef.whereEqualTo("id", movie?.id)
                    .get().addOnCompleteListener { task ->
                        if(task.isSuccessful) {
                            task.result?.let {
                                initView(movie)
                                val isRecordEmpty = it.isEmpty
                                if(isRecordEmpty) {
                                    setNormalMovieUI()
                                } else {
                                    setFavoriteMovieUI()
                                }
                            }
                        }
                    }
        }

    }

    private fun setFavoriteMovieUI() {
        binding.btnAddToFavorite.hide()
        binding.btnRemoveFromFavorite.show()
        binding.ivFavoriteStars.show()
    }

    private fun setNormalMovieUI() {
        binding.btnAddToFavorite.show()
        binding.btnRemoveFromFavorite.hide()
        binding.ivFavoriteStars.hide()
    }

    private fun getRatingStar(movie: Movie): Float {
        return (movie.vote_average / 2).toFloat()
    }
}