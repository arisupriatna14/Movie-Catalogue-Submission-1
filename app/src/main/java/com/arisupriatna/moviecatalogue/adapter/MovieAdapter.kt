package com.arisupriatna.moviecatalogue.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.arisupriatna.moviecatalogue.model.Movie
import com.arisupriatna.moviecatalogue.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter internal constructor(private val context: Context): BaseAdapter() {
    internal var movies = arrayListOf<Movie>()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val movies = getItem(position) as Movie
        viewHolder.bind(movies)

        return  itemView
    }

    private inner class ViewHolder internal constructor(private val view: View) {
        internal fun bind(movies: Movie) {
            with(view) {
                tv_title_movie.text = movies.title
                tv_release_date_movie.text = movies.releaseDate
                tv_description_movie.text = movies.description
                Glide.with(this).load(movies.imagePoster).into(img_poster)
            }
        }

    }

    override fun getItem(position: Int): Any = movies[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = movies.size

}