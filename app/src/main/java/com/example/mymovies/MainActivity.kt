package com.example.mymovies

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMovies: RecyclerView
    private val list = ArrayList<Movies>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies = findViewById(R.id.rv_movies)
        rvMovies.setHasFixedSize(true)

        list.addAll(getListMovies())
        showRecycleList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveToAbout = Intent(this@MainActivity, About::class.java)
                startActivity(moveToAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecycleList() {
        rvMovies.layoutManager = LinearLayoutManager(this)
        val listMoviesAdapter = ListMoviesAdapter(list)
        rvMovies.adapter = listMoviesAdapter
    }

    @SuppressLint("Recycle")
    private fun getListMovies(): ArrayList<Movies>  {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listMovies = ArrayList<Movies>()
        for (i in dataName.indices) {
            val Movies = Movies(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listMovies.add(Movies)
        }
        return listMovies
    }

}