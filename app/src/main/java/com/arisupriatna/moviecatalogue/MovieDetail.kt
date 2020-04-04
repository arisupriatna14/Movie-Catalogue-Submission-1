package com.arisupriatna.moviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arisupriatna.moviecatalogue.model.Movie
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        setupActionBar()
        setupView()
    }

    private fun setupView() {
        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)

        tv_title.text = movie?.title.toString()
        tv_release_date.text = movie?.releaseDate.toString()
        tv_description.text = movie?.description.toString()
        Glide.with(this).load(movie?.imagePoster).into(img_poster)
    }

    private fun setupActionBar() {
        val actionBar = supportActionBar
        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)

        actionBar?.title = movie?.title
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
