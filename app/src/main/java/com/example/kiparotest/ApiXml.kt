package com.example.kiparotest

import okhttp3.OkHttpClient
import okhttp3.Request
import org.simpleframework.xml.Serializer
import org.simpleframework.xml.core.Persister
import java.io.IOException

class ApiXml {

    private val client = OkHttpClient()

    fun getNews(): XmlNewsList {
        val request = Request.Builder()
            .url("https://api2.kiparo.com/static/it_news.xml")
            .build()
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            val serializer: Serializer = Persister()
            return serializer.read(XmlNewsList::class.java, response.peekBody(10000).string())
        }
    }
}