package com.example.kiparotest

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


class Api {

    private val client = OkHttpClient()
    private val moshi = Moshi.Builder().build()
    private val newsJsonAdapter = moshi.adapter(NewsListDto::class.java)

    fun getNews(): NewsListDto? {
        val request = Request.Builder()
            .url("https://api2.kiparo.com/static/it_news.json")
            .build()
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            return newsJsonAdapter.fromJson(response.body!!.source())
        }
    }
}