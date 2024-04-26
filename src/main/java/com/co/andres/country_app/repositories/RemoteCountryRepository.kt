package com.co.andres.country_app.repositories

import CountryVO
import com.co.andres.country_app.dto.CountryDto
import com.co.andres.country_app.service.CountryAPIService
import com.co.andres.country_app.dto.Result
import com.co.andres.country_app.mappers.CountryMapper

class RemoteCountryRepository(private val countryAPIService: CountryAPIService) : ICountryRepository {
    override suspend fun fetchAllCountry(): List<CountryVO> {
        val response = countryAPIService.fetchAllCountry()
        if (response !is List<CountryDto>) throw Exception((response as Result.Error).exception)

        return (response as List<CountryDto>).map { CountryMapper().fromDTO(it) }
    }
}