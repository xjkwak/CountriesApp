package com.tekhne.countriesapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.anncode.offersandcoupons.model.ApiAdapter
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //VIEW
        val rvCoupons: RecyclerView = findViewById(R.id.rvCoupons) //UI
        rvCoupons.layoutManager = LinearLayoutManager(this)
        val countries = ArrayList<Country>()
        //VIEW


        //CONTROLLER
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getAllCountries()

        call.enqueue(object : Callback<JsonArray> {
            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                Log.e("ERROR: ", t.message)
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {

                val offersJsonArray = response.body()?.asJsonArray
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Country(jsonObject)
                    countries.add(coupon)
                }
                //VIEW
                rvCoupons.adapter = RecyclerCountryAdapter(countries, R.layout.card_coupon)
                //VIEW
            }
        })
        //CONTROLLER
    }
}
