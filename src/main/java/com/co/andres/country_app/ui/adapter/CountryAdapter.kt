package com.co.andres.country_app.ui.adapter

import CountryVO
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.co.andres.country_app.R
import android.widget.Button
import com.squareup.picasso.Picasso

class CountryAdapter(
    private val countries: List<CountryVO>,
    private val openMap: ICountryMap
) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewCountry = LayoutInflater.from(parent.context).inflate(R.layout.country_detail_layout, parent, false)
        return ViewHolder(viewCountry)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        val imageURL = country.flags[0]
        Picasso.get().load(imageURL).into(holder.flagImageView)

        holder.nameTextView.text = country.name
        holder.capitalTextView.text = country.capital?.get(0)
        holder.regionTextView.text = country.region
        holder.mapsButton.text = holder.mapsButton.contentDescription

        holder.mapsButton.setOnClickListener {
            country.maps?.let {item -> openMap.onCountryMapClick(item) }
        }
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flagImageView: ImageView = itemView.findViewById(R.id.flag_country)
        val nameTextView: TextView = itemView.findViewById(R.id.name_country)
        val capitalTextView: TextView = itemView.findViewById(R.id.country_capital)
        val regionTextView: TextView = itemView.findViewById(R.id.region)
        val mapsButton: Button = itemView.findViewById(R.id.maps)
    }
}
