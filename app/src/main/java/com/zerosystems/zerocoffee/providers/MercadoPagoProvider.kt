package com.zerosystems.zerocoffee.providers

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.zerosystems.zerocoffee.api.MercadoPagoApiRoutes
import com.zerosystems.zerocoffee.models.MercadoPagoCardTokenBody
import com.zerosystems.zerocoffee.routes.MercadoPagoRoutes
import retrofit2.Call

class MercadoPagoProvider {

    var mercadoPagoRoutes: MercadoPagoRoutes? = null

    init {
        val api = MercadoPagoApiRoutes()
        mercadoPagoRoutes = api.getMercadoPagoRoutes()
    }

    fun getInstallments(bin: String, amount: String): Call<JsonArray>? {
        return mercadoPagoRoutes?.getInstallments(bin, amount)
    }

    fun createCardToken(mercadoPagoCardTokenBody: MercadoPagoCardTokenBody): Call<JsonObject>? {
        return mercadoPagoRoutes?.createCardToken(mercadoPagoCardTokenBody)
    }

}