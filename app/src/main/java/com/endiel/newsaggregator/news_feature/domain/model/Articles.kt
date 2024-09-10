package com.endiel.newsaggregator.news_feature.domain.model

data class Articles(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)