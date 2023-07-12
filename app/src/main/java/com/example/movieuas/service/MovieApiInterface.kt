package com.example.movieuas.service

import com.example.movieuas.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("/3/movie/popular?api_key=4d3abaa163bd861a8ce7ffd8595d37f4")
    fun getMovieList(): Call<MovieResponse>
}