package com.example.kiparotest


fun main() {

    println(Api().getNews()?.news?.joinToString("\n"))
}