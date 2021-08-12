package com.timelysoft.tsjdomcom.service

import com.example.testkoin.servise.AuthInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitService {
    val retrofitService = module {
        factory {client(get(), get())}
        factory { retrofit()}
        factory { apiService()}
    }

    fun client(authInterceptor: AuthInterceptor, loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(authInterceptor).addInterceptor(loggingInterceptor).build()
    }

    private fun retrofit(baseUrl: String = "https://api.first.org/data/"): Retrofit =
        Retrofit.Builder()
            .client(OkHttpClient())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    fun apiService(): ApiService {
        return retrofit().create(ApiService::class.java)
    }
}