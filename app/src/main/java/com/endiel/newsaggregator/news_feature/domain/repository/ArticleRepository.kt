package com.endiel.newsaggregator.news_feature.domain.repository

import com.endiel.newsaggregator.news_feature.domain.model.Article
import com.endiel.newsaggregator.news_feature.domain.model.Articles

// This interface defines a contract of what Article Repository Implimantation should do and not how
interface ArticleRepository {
    suspend fun getArticles(query: String): List<Article>
}