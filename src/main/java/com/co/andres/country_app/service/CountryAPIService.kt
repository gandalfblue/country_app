package com.co.andres.country_app.service

import com.co.andres.country_app.dto.CountryDto
import retrofit2.http.GET

interface CountryAPIService {
    @GET("v3.1/all")
    suspend fun fetchAllCountry(): List<CountryDto>
}