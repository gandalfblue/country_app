package com.co.andres.country_app.dto

import com.google.gson.annotations.SerializedName

data class CountryDto (
    @SerializedName("name") val name: Name? = null,
    @SerializedName("capital") val capital: List<String>? = null,
    @SerializedName("region") val region: String? = null,
    @SerializedName("maps") val maps: Maps? = null,
    @SerializedName("flags") val flags: Flags? = null,
)

data class Flags (
    @SerializedName("png") val png: String? = null,
    @SerializedName("svg") val svg: String? = null,
    @SerializedName("alt") val alt: String? = null
)

data class Maps (
    @SerializedName("googleMaps") val googleMaps: String? = null,
    @SerializedName("openStreetMaps") val openStreetMaps: String? = null
)

data class Name (
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null,
)