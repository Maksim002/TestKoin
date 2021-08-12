package com.example.testkoin.servise

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

object ApiAccessories {
//    var apiAccessories = module {
//
//        factory {
//            authInterceptor()
//        }
//
//        factory {
//            client()
//        }
//    }

    private fun authInterceptor() = Interceptor { chain ->
        val newUrl = chain.request().url
                .newBuilder()
                .build()

        val newRequest = chain.request()
                .newBuilder()
                .addHeader("Authorization", "bearer ")
                .url(newUrl)
                .build()

        chain.proceed(newRequest)
    }

    fun client() = OkHttpClient().newBuilder()
            .addInterceptor(authInterceptor())
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .build()
}