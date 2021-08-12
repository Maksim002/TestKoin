package com.example.testkoin.di

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newUrl = chain.request().url
                .newBuilder()
                .build()

        val newRequest = chain.request()
                .newBuilder()
                .addHeader("Authorization", "bearer ")
                .url(newUrl)
                .build()

        return chain.proceed(newRequest)
    }
}