package com.example.homework

import retrofit2.http.GET
import retrofit2.Call

interface MovieItem {
    @GET("movie/550?api_key=973086a14eaeb40eacd4912ffbbf3f59")
    fun getMovies(): Call<MovieInfo>
}