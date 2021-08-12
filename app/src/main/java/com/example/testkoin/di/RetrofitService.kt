package com.example.testkoin.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.example.testkoin.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitService {
    val retrofitService = module {
        single {client(get(), get()) }
        single { apiService(get()) }
    }

    fun client(authInterceptor: AuthInterceptor, loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(authInterceptor).addInterceptor(loggingInterceptor).build()
    }

    private fun retrofit(baseUrl: String = "https://api.first.org/data/", client: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()

    fun apiService(client: OkHttpClient): ApiService {
        return retrofit(client = client).create(ApiService::class.java)
    }
}