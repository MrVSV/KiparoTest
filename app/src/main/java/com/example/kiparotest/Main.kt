package com.example.kiparotest

private val apiJson = ApiJson()
private val apiXml = ApiXml()
private val repository = Repository(apiJson, apiXml)

fun main() {

    var sourceId: Int
    while (true) {
        println("Enter 1 to download Json\nEnter 2 to download XML\nEnter 0 to exit")
        sourceId = readLine()?.toIntOrNull() ?: return
        when (sourceId) {
            in 1..2 -> selectSource(sourceId)
            0 -> {
                println("Good Bay")
                break
            }
            else -> println("Wrong command")
        }
    }
}

fun selectSource(sourceId: Int) {
    val news: List<News>
    when(sourceId) {
        1 -> {
            println("Downloading Json")
            news = repository.getNewsFromJson()!!
            println("Enter 1 to see all news\nEnter 2 to select news by keywords")
            val viewTypeId: Int = readLine()?.toIntOrNull() ?: return
            selectViewType(viewTypeId, news)
        }
        2 -> {println("Downloading XML")
            news = repository.getNewsFromXml()
            println("Enter 1 to see all news\nEnter 2 to select news by keywords")
            val viewTypeId: Int = readLine()?.toIntOrNull() ?: return
            selectViewType(viewTypeId, news)
        }
        else -> {
            println("Wrong source, try again")
        }
    }
}

fun selectViewType(viewTypeId: Int, news: List<News>) {
    val keyword: String
    val keywordList = mutableSetOf<String>()
    when (viewTypeId) {
        1 -> showOrderedNews(news)
        2 -> {
            println("Enter one of following keywords:")
            news.forEach {
                keywordList.addAll(it.keywords)
            }
            println(keywordList.toString())
            keyword = readLine().toString()
            showNewsByKeywords(keyword, news)
        }
        else -> println("Wrong view type, try again")
    }
}

    fun showOrderedNews(news: List<News>) {
        news.sortedBy { it.date }.forEach { item -> showNewsItem(item) }
    }

    fun showNewsByKeywords(keyword: String, news: List<News>) {
        if (news.all { !it.keywords.contains(keyword) }) {
            println("Wrong keyword, try again")
            selectViewType(2, news)
        } else for (item in news) {
            if (item.keywords.contains(keyword)) {
                showNewsItem(item)
            }
        }
    }

    fun showNewsItem(item: News) {
        println("${dateFormat(item.date)}\n${item.title}\n${item.description}")
        println()
    }