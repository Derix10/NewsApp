package com.example.newsapp

import android.app.Application

class App: Application() {
    companion object{
        lateinit var api : NewsApi
    }

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit()
        api = retrofit.getApi()
    }
}