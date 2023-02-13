package com.example.kiparotest

class Repository(private val apiJson: ApiJson, private val apiXml: ApiXml) {

    fun getNewsFromJson(): List<News>? = apiJson.getNews()?.news?.fromJsonToListNews()

    fun getNewsFromXml(): List<News> = apiXml.getNews().news.fromXmlToListNews()
}