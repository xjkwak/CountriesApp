package com.anncode.offersandcoupons.model

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("all")
    fun getAllCountries(): Call<JsonArray>
}