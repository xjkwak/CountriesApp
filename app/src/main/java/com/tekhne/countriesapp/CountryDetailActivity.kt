package com.tekhne.countriesapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class CountryDetailActivity : AppCompatActivity() {

    private var countrySelected:Country? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)

        countrySelected = intent.getSerializableExtra("COUNTRY") as Country

        var text_view_name: TextView = findViewById(R.id.text_view_name)
        var text_view_capital: TextView = findViewById(R.id.text_view_capital)
        var text_view_region: TextView = findViewById(R.id.text_view_region)
        var text_view_subregion: TextView = findViewById(R.id.text_view_subregion)
        var text_view_capital_detail: TextView = findViewById(R.id.text_view_capital_detail)
        var text_view_population: TextView = findViewById(R.id.text_view_population)
        var text_view_area: TextView = findViewById(R.id.text_view_area)
        var img_view_flag: ImageView = findViewById(R.id.img_view_flag)
        var img_view_flag_small: CircleImageView = findViewById(R.id.img_view_flag_small)

        text_view_name.text = countrySelected?.name
        text_view_capital.text = countrySelected?.capital
        text_view_region.text = countrySelected?.region
        text_view_subregion.text = countrySelected?.subregion
        text_view_capital_detail.text = countrySelected?.capital
        text_view_population.text = countrySelected?.population
        text_view_area.text = countrySelected?.area
        Picasso.get().load(countrySelected?.flagUrl).resize(520, 520).centerCrop().into(img_view_flag)
        Picasso.get().load(countrySelected?.flagUrl).resize(520, 520).centerCrop().into(img_view_flag_small)
    }
}
