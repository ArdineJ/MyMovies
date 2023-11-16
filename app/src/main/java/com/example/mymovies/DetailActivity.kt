package com.example.mymovies

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataMovies = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("key_movies", Movies::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_movies")
        }

        if (dataMovies != null) {
            val tvDetailName:TextView = findViewById(R.id.tv_name_detail)
            val tvDetailDescription:TextView = findViewById(R.id.tv_description_detail)
            val ivDetailPhoto:ImageView = findViewById(R.id.iv_detail_photo)

            // Set the movie details to the views
            tvDetailName.text = dataMovies.name
            tvDetailDescription.text = dataMovies.description
            ivDetailPhoto.setImageResource(dataMovies.photo)
        }
    }
}