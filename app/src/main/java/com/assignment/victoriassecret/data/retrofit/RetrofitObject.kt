package com.assignment.victoriassecret.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
val baseUrl = "https://run.mocky.io/v3/bc09a745-4346-4025-9611-9da76366dbbc"
    val retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/bc09a745-4346-4025-9611-9da76366dbbc")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}