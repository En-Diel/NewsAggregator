package com.endiel.newsaggregator.news_feature.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.endiel.newsaggregator.news_feature.domain.model.Article

@Composable
fun ArticlesScreen(
    modifier: Modifier = Modifier,
    articlesViewModel: ArticlesViewModel = hiltViewModel()
) {
    var query by remember {
        mutableStateOf("")
    }
    val articlesList = articlesViewModel.state.value.articles

    if (articlesList.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            TextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Search") },
                modifier = modifier
            )
            Button(
                onClick = { articlesViewModel.getArticles(query) },
                modifier = modifier
            ) {
                Text("Search")
            }
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(articlesList.size) { index ->
                    ArticleItem(articlesList[index])
                }
            }
        }
    }
}

@Composable
fun ArticleItem(
    article: Article,
) {
    // Testing the outcome
    Text(text = article.title)
    Text(text = article.content)
    Text(text = article.description)
    Text(text = article.publishedAt)
    Text(text = article.author)
    Text(text = article.url)
    Text(text = article.urlToImage)
    Text(text = "${article.source}")
}