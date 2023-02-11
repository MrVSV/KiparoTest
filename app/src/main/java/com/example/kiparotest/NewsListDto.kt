package com.example.kiparotest
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsListDto(
    val name: String,
    val location: String,
    val news: List<NewsDto>
)