package com.uc.mymovies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.uc.mymovies.dto.Movie

class ListAdapter(private val context: Context, var movies: ArrayList<Movie>):BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View? = convertView
        val viewHolder: ViewHolder

        if (view == null) {
            viewHolder = ViewHolder()
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item, null, true)

            viewHolder.name = view.findViewById(R.id.name)
            viewHolder.image = view.findViewById(R.id.image)
            viewHolder.favoriteImage = view.findViewById(R.id.favorite)

            view!!.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        viewHolder.name?.text = movies[position].title
        var imageURL = movies[position].image
        Picasso.get().load(imageURL).into(viewHolder.image)

        //Check if user has movie as favorite, if so set image. (Rows are reused, must reset image).
        checkIfFavorite(viewHolder, position)

        //Set click listener. If user favorites change image
        viewHolder.favoriteImage?.setOnClickListener {
            movies[position].isFavorite = !movies[position].isFavorite

            checkIfFavorite(viewHolder, position)
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return movies.size
    }

    private fun checkIfFavorite(viewHolder: ViewHolder, position: Int) {
        if (movies[position].isFavorite) {
            viewHolder.favoriteImage?.setImageResource(R.drawable.favorite)
        } else {
            viewHolder.favoriteImage?.setImageResource(R.drawable.notfavorite)
        }
    }

    inner class ViewHolder {
        var name: TextView? = null
        internal var image: ImageView? = null
        internal var favoriteImage: ImageView? = null
    }
}