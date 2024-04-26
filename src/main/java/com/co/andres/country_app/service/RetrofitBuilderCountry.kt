package com.co.andres.country_app.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilderCountry {
    private const val BASE_URL = "https://restcountries.com/"

    val countryAPIService : CountryAPIService by lazy {
        getRetrofit().create(CountryAPIService::class.java)
    }

    private fun getRetrofit(): Retrofit {
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()

        val logging = HttpLoggingInterceptor()

        httpClient.addInterceptor(logging)

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }
}