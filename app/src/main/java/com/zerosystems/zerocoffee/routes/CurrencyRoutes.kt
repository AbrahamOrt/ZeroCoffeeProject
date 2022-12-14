package com.zerosystems.zerocoffee.routes


import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface CurrencyRoutes {

    @GET("convert?q=TEST-40a80dbc-df47-45ba-8951-5f197c7199c0")
    fun getCurrencyValue(): Call<JsonObject>


}
