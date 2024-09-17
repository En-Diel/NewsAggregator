package com.endiel.newsaggregator.news_feature.presentation

import com.endiel.newsaggregator.news_feature.domain.model.Article

// This represents the current ui state as we want to show it
data class ArticleState(
    // A list of articles will be shown
    val articles: List<Article> = emptyList(),
    // The loading will be done
    val isLoading: Boolean = false,
    // There'll be no error at first
    val error: String? = null
)