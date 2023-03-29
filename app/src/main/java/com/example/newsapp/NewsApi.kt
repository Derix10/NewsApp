package com.example.newsapp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("q") query: String?,
        @Query("apiKey")apiKey: String
    ): Call<NewsApiResponse>
}