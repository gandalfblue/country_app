package com.co.andres.country_app.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.co.andres.country_app.databinding.CountriesFragmentBinding
import com.co.andres.country_app.ui.adapter.CountryAdapter
import com.co.andres.country_app.ui.adapter.ICountryMap
import com.co.andres.country_app.ui.managers.CountryViewModel
import com.co.andres.country_app.ui.managers.CountryViewModelFactory

class MainActivity : AppCompatActivity(), ICountryMap {
    private lateinit var bindingCountry: CountriesFragmentBinding
    private lateinit var viewModel: CountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingCountry = CountriesFragmentBinding.inflate(layoutInflater)
        setContentView(bindingCountry.root)
        initViewModel()
        setObservers()
        viewModel.fecthCountryDetails()
    }

    override fun onStart() {
        super.onStart()
    }

    private fun initViewModel() {
        val factory = CountryViewModelFactory()
        viewModel = ViewModelProvider(this,factory)[CountryViewModel::class.java]
    }

    private fun setObservers() {
        viewModel.getCountries().observe(this){
            bindingCountry.recyclerViewCountries.adapter = CountryAdapter( it, this )
        }
    }

    override fun onCountryMapClick(urlMap: String) {

        val intent = Intent(this, CountryMapActivity::class.java)
        intent.putExtra("urlMap", urlMap)
        startActivityForResult(intent, 0)

    }

}