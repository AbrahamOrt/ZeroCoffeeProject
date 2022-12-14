package com.zerosystems.zerocoffee.routes


import com.zerosystems.zerocoffee.models.MercadoPagoPayment
import com.zerosystems.zerocoffee.models.ResponseHttp
import retrofit2.Call
import retrofit2.http.*

interface PaymentsRoutes {

    @POST("payments/create")
    fun createPayment(
        @Body mercadoPagoPayment: MercadoPagoPayment,
        @Header("Authorization") token: String
    ): Call<ResponseHttp>

}