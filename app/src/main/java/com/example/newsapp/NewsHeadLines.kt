package com.example.newsapp

data class NewsHeadLines(
    val title: String,
    val description: String,
    val author : String,
    val publishedAt: String,
    val urlToImage: String,
    val content : String
): java.io.Serializable