package com.zerosystems.zerocoffee.providers

import com.google.gson.JsonObject
import com.zerosystems.zerocoffee.api.CurrencyApiRoutes
import com.zerosystems.zerocoffee.routes.CurrencyRoutes
import retrofit2.Call

class CurrencyProvider() {

    private var currencyRoutes: CurrencyRoutes? = null

    init {
        val api = CurrencyApiRoutes()
        currencyRoutes = api.getCurrencyRoutes()
    }

    fun getCurrencyValue(): Call<JsonObject>? {
        return currencyRoutes?.getCurrencyValue()
    }


}