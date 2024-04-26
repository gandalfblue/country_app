package com.co.andres.country_app.ui.managers

import CountryVO
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.co.andres.country_app.repositories.ICountryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountryViewModel(private val countryRepository: ICountryRepository) : ViewModel() {
    private var scope = CoroutineScope(Dispatchers.IO)
    private val countries = MutableLiveData<List<CountryVO>>().apply { value = listOf() }
    fun getCountries(): LiveData<List<CountryVO>> = countries

    fun fecthCountryDetails() {
        scope.launch{
            val result = countryRepository.fetchAllCountry()
            countries.postValue(result)
        }
    }
}