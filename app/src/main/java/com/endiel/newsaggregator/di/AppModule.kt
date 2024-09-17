package com.endiel.newsaggregator.di

import com.endiel.newsaggregator.news_feature.common.Constants
import com.endiel.newsaggregator.news_feature.data.remote.ArticlesApi
import com.endiel.newsaggregator.news_feature.data.repository.ArticleRepositoryImpl
import com.endiel.newsaggregator.news_feature.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // Retrofit Service initialization
    @Provides
    @Singleton
    fun provideArticlesApi(): ArticlesApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(Constants.okHttpClient.build())
            .build()
            .create(ArticlesApi::class.java)
    }
    /* We'll the one in the Repository Module for now, as it generates less codes
    @Provides
    @Singleton
    fun provideArticleRepository(articlesApi: ArticlesApi): ArticleRepository {
        return ArticleRepositoryImpl(articlesApi)
    }
     */
}