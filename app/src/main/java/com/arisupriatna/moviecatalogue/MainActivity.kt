package com.arisupriatna.moviecatalogue

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import com.arisupriatna.moviecatalogue.adapter.MovieAdapter
import com.arisupriatna.moviecatalogue.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MovieAdapter
    private lateinit var dataTitleMovie: Array<String>
    private lateinit var dataReleaseDateMovie: Array<String>
    private lateinit var dataDescriptionMovie: Array<String>
    private lateinit var dataImagePosterMovie: TypedArray

    private var movies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        adapter = MovieAdapter(this)
        lv_list_movie.adapter = adapter

        prepare()
        addItem()

        lv_list_movie.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val movieIntent = Intent(this, MovieDetail::class.java)
            movieIntent.putExtra(MovieDetail.EXTRA_MOVIE, movies[position])
            startActivity(movieIntent)
        }
    }

    private fun prepare() {
        dataTitleMovie = resources.getStringArray(R.array.data_title_movie)
        dataReleaseDateMovie = resources.getStringArray(R.array.data_release_date)
        dataDescriptionMovie = resources.getStringArray(R.array.data_description_movie)
        dataImagePosterMovie = resources.obtainTypedArray(R.array.data_poster)
    }

    private fun addItem() {
        for (position in dataTitleMovie.indices) {
            val movie = Movie(
                dataTitleMovie[position],
                dataDescriptionMovie[position],
                dataImagePosterMovie.getResourceId(position, -1),
                dataReleaseDateMovie[position]
            )
            movies.add(movie)
        }
        adapter.movies = movies
    }
}
