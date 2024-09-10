package com.endiel.newsaggregator.news_feature.data.remote

import com.endiel.newsaggregator.news_feature.domain.model.Articles
import com.endiel.newsaggregator.news_feature.domain.model.Source
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApi {
    // Request any keyword
    @GET("/v2/everything")
    suspend fun getNews(@Query("q") q: String): List<Articles>
    // Request Headlines
    @GET("/v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country") country: String,
        @Query("category") category: String
    ): List<Articles>
    // Request Sources
    @GET("/v2/top-headlines/sources")
    suspend fun getSources(
        @Query("country") country: String,
        @Query("category") category: String
    ): List<Source>
}