package com.example.kiparotest

class Repository(private val apiJson: ApiJson) {

    fun getNewsFromJson(): List<News>? = apiJson.getNews()?.news?.toListNews()
}