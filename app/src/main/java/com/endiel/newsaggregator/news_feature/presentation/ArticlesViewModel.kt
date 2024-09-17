package com.endiel.newsaggregator.news_feature.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.endiel.newsaggregator.news_feature.common.Result
import com.endiel.newsaggregator.news_feature.domain.use_case.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase
): ViewModel() {
    // We make it private so that it can only be altered in the viewModel
    private val _state = mutableStateOf(ArticleState())
    // We make it public coz we need to access this in our ui
    val state: State<ArticleState> = _state
    // The block inside here is executed as soon as the viewModel is created
    /*
    init {
    }
    */
    fun getArticles(query: String) {
        // We run the operation in coroutine, coz it's a network call
        viewModelScope.launch {
            getArticlesUseCase(query).onEach { result ->
                when(result) {
                    is Result.Success -> {
                        // We set the _state value to new value
                        _state.value = ArticleState(articles = result.data ?: emptyList())
                    }
                    is Result.Loading -> {
                        // We set the _state value to new value
                        _state.value = ArticleState(isLoading = true)
                    }
                    is Result.Error -> {
                        // We set the _state value to new value
                        _state.value = ArticleState(error = result.message?: "An unexpected error has occured")
                    }
                }
            }
        }
    }
}