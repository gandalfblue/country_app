package com.co.andres.country_app.ui.view

import android.app.Activity
import android.os.Bundle
import com.co.andres.country_app.databinding.CountryMapFragmentBinding

class CountryMapActivity: Activity() {
    private var urlMap: String = ""

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       val binding = CountryMapFragmentBinding.inflate(layoutInflater)
       setContentView(binding.root)
       if (intent.extras?.containsKey("urlMap") == true) {
           urlMap = intent.extras!!.getString("urlMap").toString()
           binding.countryMap.loadUrl(urlMap)
       }
   }
}

