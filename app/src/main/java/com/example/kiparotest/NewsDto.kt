package com.example.kiparotest

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsDto(
    val id: Int,
    val title: String?,
    val description: String,
    val date: String,
    val keywords: List<String>,
    val visible: Boolean
)