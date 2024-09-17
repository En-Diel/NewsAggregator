package com.endiel.newsaggregator.news_feature.domain.model

// The Articles data class object from the Api
data class Articles(
    val articles: List<Article> = emptyList(),
    val status: String,
    val totalResults: Int
)