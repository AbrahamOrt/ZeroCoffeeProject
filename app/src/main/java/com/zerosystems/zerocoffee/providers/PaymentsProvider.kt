package com.zerosystems.zerocoffee.providers

import com.zerosystems.zerocoffee.api.ApiRoutes
import com.zerosystems.zerocoffee.models.MercadoPagoPayment
import com.zerosystems.zerocoffee.models.ResponseHttp
import com.zerosystems.zerocoffee.routes.PaymentsRoutes
import retrofit2.Call

class PaymentsProvider(val token: String) {

    private var paymentsRoutes: PaymentsRoutes? = null

    init {
        val api = ApiRoutes()
        paymentsRoutes = api.getPaymentsRoutes(token)
    }

    fun create(mercadoPagoPayment: MercadoPagoPayment): Call<ResponseHttp>? {
        return paymentsRoutes?.createPayment(mercadoPagoPayment, token)
    }

}