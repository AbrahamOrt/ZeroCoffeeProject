package com.optic.deliverykotlinudemy.routes

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.optic.deliverykotlinudemy.models.MercadoPagoCardTokenBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MercadoPagoRoutes {

    @GET("v1/payment_methods/installments?access_token=TEST-3079885896947439-121400-51eac942a27628b3def14211bc82ee01-494480056")
    fun getInstallments(@Query("bin") bin: String, @Query("amount") amount: String): Call<JsonArray>

    @POST("v1/card_tokens?public_key=TEST-40a80dbc-df47-45ba-8951-5f197c7199c0")
    fun createCardToken(@Body body: MercadoPagoCardTokenBody): Call<JsonObject>
}
