package com.endiel.newsaggregator.news_feature.domain.use_case

import com.endiel.newsaggregator.news_feature.common.Result
import com.endiel.newsaggregator.news_feature.domain.model.Article
import com.endiel.newsaggregator.news_feature.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

// This functions gets all the articles from the api repository
class GetArticlesUseCase @Inject constructor(private val repository: ArticleRepository) {
    operator fun invoke(query: String): Flow<Result<List<Article>>> = flow {
        try {
            emit(Result.Loading())
            val articles = repository.getArticles(query)
            emit(Result.Success(articles))
        } catch (e: HttpException) {
            emit(Result.Error(e. localizedMessage ?: "Unexpected error has occured"))
        } catch (e: IOException) {
            emit(Result.Error("Couldn't reach server, check your internet connection."))
        }
    }
}