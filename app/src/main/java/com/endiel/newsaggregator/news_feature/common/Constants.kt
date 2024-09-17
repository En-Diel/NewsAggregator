package com.endiel.newsaggregator.news_feature.common

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object Constants {
    // Root url from Api
    const val BASE_URL = "https://newsapi.org"
    // Logger to be added to the http client
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    // Custom Header Interceptor(We apply before logger, so it can be logged out in the logcat),
    // then we add it to the OkHttp client
    private val headInterceptor = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()
            request = request.newBuilder()
                .addHeader("Authorization", "f14ea10d92fa4faf90792d77ff53cff1")
                // You can add as many applicable headers as possible here
                .build()
            val response: Response = chain.proceed(request)
            return response
        }

    }
    // Create OkHttp Client
    val okHttpClient = OkHttpClient.Builder()
        .callTimeout(5, TimeUnit.SECONDS) // Default callTime out is 10s
        .addInterceptor(headInterceptor) // Our header
        .addInterceptor(logger) // Our logger
}