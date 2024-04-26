package com.co.andres.country_app.mappers

import CountryVO
import com.co.andres.country_app.dto.CountryDto

class CountryMapper {
    fun fromDTO(dto: CountryDto): CountryVO {
        val flagsList = mutableListOf<String>()
        dto.flags?.png?.let { flagsList.add(it) }
        dto.flags?.svg?.let { flagsList.add(it) }
        dto.flags?.alt?.let { flagsList.add(it) }
        return CountryVO(
            name = dto.name?.common,
            capital = dto.capital,
            region = dto.region,
            maps = dto.maps?.googleMaps,
            flags = flagsList,
        )
    }
}