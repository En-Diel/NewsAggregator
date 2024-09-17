package com.endiel.newsaggregator.news_feature.domain.model

// The Article data class object from the Api
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)