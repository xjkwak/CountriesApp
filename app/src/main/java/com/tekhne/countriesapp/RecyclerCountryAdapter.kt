package com.tekhne.countriesapp

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class RecyclerCountryAdapter(var countries : ArrayList<Country>, var resource: Int) : RecyclerView.Adapter<RecyclerCountryAdapter.CardCountryHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardCountryHolder {
        var view: View = LayoutInflater.from(p0!!.context).inflate(resource, p0, false)
        return CardCountryHolder(view)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(p0: CardCountryHolder, p1: Int) {
        var country = countries.get(p1)
        p0.setDataCard(country)
    }

    class CardCountryHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var country: Country? = null
        private var img_view_flag: ImageView = v.findViewById(R.id.img_view_flag)
        private var text_view_name: TextView = v.findViewById(R.id.text_view_name)
        private var text_view_capital: TextView = v.findViewById(R.id.text_view_capital)
        private var text_view_region: TextView = v.findViewById(R.id.text_view_region)
        private var text_view_subregion: TextView = v.findViewById(R.id.text_view_subregion)

        init {
            v.setOnClickListener(this)
        }

        fun setDataCard(country: Country){
            this.country = country
            Log.i("FLAG URL: ", country.flagUrl)
            Picasso.get().load(country.flagUrl).resize(520, 520).centerCrop().into(img_view_flag)
            text_view_name.setText(country.name)
            text_view_capital.setText(country.capital)
            text_view_region.setText(country.region)
            text_view_subregion.setText(country.subregion)
        }

        override fun onClick(v: View) {
            Log.i("CLICK Country: ", country?.name)
            val context = v.context
            val showPhotoIntent = Intent(context, CountryDetailActivity::class.java)
            showPhotoIntent.putExtra("COUNTRY", country)
            context.startActivity(showPhotoIntent)
        }
    }
}
