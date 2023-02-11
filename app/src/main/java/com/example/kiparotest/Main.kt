package com.example.kiparotest

private val apiJson = ApiJson()
private val repository = Repository(apiJson)

fun main() {

    repository.getNewsFromJson()?.sortedBy { news -> news.date }?.forEach {
        println("${it.date.dateFormat(it.date)}\n${it.title}\n${it.description}")
    }
}