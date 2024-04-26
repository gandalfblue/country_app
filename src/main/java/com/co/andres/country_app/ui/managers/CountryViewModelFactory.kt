package com.co.andres.country_app.ui.managers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.co.andres.country_app.repositories.ICountryRepository
import com.co.andres.country_app.repositories.RemoteCountryRepository
import com.co.andres.country_app.service.RetrofitBuilderCountry

class CountryViewModelFactory(private val countryRepository: ICountryRepository) : ViewModelProvider.Factory {

    constructor():this(
        RemoteCountryRepository(
           RetrofitBuilderCountry.countryAPIService
        )
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CountryViewModel(countryRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}