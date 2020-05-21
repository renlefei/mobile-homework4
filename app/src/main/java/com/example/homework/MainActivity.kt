package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Response
import retrofit2.Call
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: MovieAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter = MovieAdapter(emptyList())
        recyclerView = findViewById<RecyclerView>(R.id.playList).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        val request = HttpRequest.buildService(MovieItem::class.java)
        val call = request.getMovies()
        call.enqueue(object : Callback, retrofit2.Callback<MovieInfo> {
            override fun onResponse(careVvvill: Call<MovieInfo>, response: Response<MovieInfo>) {
                if (response.isSuccessful){
                    val movieItem: MovieInfo = response.body()!!
                    val movieList = listOf(movieItem,movieItem,movieItem)
                    viewAdapter.setMoviesList(movieList)

                }
            }

            override fun onFailure(call: Call<MovieInfo>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Connection Failure", Toast.LENGTH_SHORT).show()
            }

        })
    }
}
