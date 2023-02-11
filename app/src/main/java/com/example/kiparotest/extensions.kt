package com.example.kiparotest

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun List<NewsDto>.toListNews(): List<News> =
    this.map { item -> item.toNews() }

fun NewsDto.toNews() = News(
    id = id,
    title = title,
    description = description,
    date = date,
    keywords = keywords,
    visible = visible
)

fun String.dateFormat(string: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss [.SSS]Z")
    val date = LocalDateTime.parse(string, formatter)
    val newFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm")
    return date.format(newFormatter)
}
