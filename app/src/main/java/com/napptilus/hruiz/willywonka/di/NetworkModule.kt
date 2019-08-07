package com.napptilus.hruiz.willywonka.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.napptilus.hruiz.willywonka.utils.WillyWonkaApi
import com.napptilus.hruiz.willywonka.utils.WillyWonkaService

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val baseUrl = "https://2q2woep105.execute-api.eu-west-1.amazonaws.com/napptilus/"

val networkModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideWillyWonkaApi(get()) }
    single { provideWillyWonkaService(get()) }
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder()
        .build()
}


fun provideRetrofit(client: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .client(client)
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

fun provideWillyWonkaApi(retrofit: Retrofit): WillyWonkaApi = retrofit.create(WillyWonkaApi::class.java)


fun provideWillyWonkaService(willyWonkaApi: WillyWonkaApi): WillyWonkaService {
    return WillyWonkaService(willyWonkaApi)
}