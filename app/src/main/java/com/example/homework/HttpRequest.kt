package com.example.homework

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpRequest {

    private var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}