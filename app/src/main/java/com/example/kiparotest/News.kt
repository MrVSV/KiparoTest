package com.example.kiparotest

data class News(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val keywords: List<String>,
    val visible: Boolean
)
