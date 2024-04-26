package com.co.andres.country_app.repositories

import CountryVO

interface ICountryRepository {
    suspend fun fetchAllCountry(): List<CountryVO>
}