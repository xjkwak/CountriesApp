package com.tekhne.countriesapp

import com.google.gson.JsonObject
import java.io.Serializable

class Country(couponJson: JsonObject?) : Serializable {

    lateinit var name: String
    lateinit var capital: String
    lateinit var area: String
    lateinit var population: String
    lateinit var flagUrl: String
    lateinit var code: String
    lateinit var region: String
    lateinit var subregion: String

    init {
        try {
            name = couponJson!!.get(NAME).asString
            capital = couponJson!!.get(CAPITAL).asString
            code = couponJson!!.get(ALPHA_2_CODE).asString.toLowerCase()
            flagUrl = "https://www.countryflags.io/${code}/flat/64.png"
            region = couponJson!!.get(REGION).asString
            subregion = couponJson!!.get(SUBREGION).asString
            area = couponJson!!.get(AREA).asString
            population = couponJson!!.get(POPULATION).asString
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    companion object {
        private val NAME                = "name"
        private val CAPITAL             = "capital"
        private val AREA                = "area"
        private val POPULATION          = "population"
        private val ALPHA_2_CODE        = "alpha2Code"
        private val REGION              = "region"
        private val SUBREGION           = "subregion"
    }
}