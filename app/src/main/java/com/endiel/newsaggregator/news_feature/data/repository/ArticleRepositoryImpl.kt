package com.endiel.newsaggregator.news_feature.data.repository

import com.endiel.newsaggregator.news_feature.data.remote.ArticlesApi
import com.endiel.newsaggregator.news_feature.domain.model.Article
import com.endiel.newsaggregator.news_feature.domain.model.Articles
import com.endiel.newsaggregator.news_feature.domain.repository.ArticleRepository
import javax.inject.Inject

// This repository implements the repository interface we defined
class ArticleRepositoryImpl @Inject constructor(
    private val articlesApi: ArticlesApi
): ArticleRepository {
    override suspend fun getArticles(query: String): List<Article> {
        return articlesApi.getArticles(query)
    }
}