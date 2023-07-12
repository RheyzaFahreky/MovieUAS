package com.example.movieuas.service

import com.example.movieuas.model.TVResponse
import retrofit2.Call
import retrofit2.http.GET

interface TVApiInterface {
    @GET("/3/tv/popular?api_key=4d3abaa163bd861a8ce7ffd8595d37f4")
    fun getTVList(): Call<TVResponse>
}