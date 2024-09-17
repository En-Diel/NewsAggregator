package com.endiel.newsaggregator.di

import com.endiel.newsaggregator.news_feature.data.repository.ArticleRepositoryImpl
import com.endiel.newsaggregator.news_feature.domain.repository.ArticleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
// This works if you want to provide an interface or abstract class
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindArticleRepository(articleRepositoryImpl: ArticleRepositoryImpl): ArticleRepository
}