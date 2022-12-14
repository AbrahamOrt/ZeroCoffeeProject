package com.zerosystems.zerocoffee.routes


import com.zerosystems.zerocoffee.models.Address
import com.zerosystems.zerocoffee.models.ResponseHttp
import retrofit2.Call
import retrofit2.http.*


interface AddressRoutes {

    @GET("address/findByUser/{id_user}")
    fun getAddress(
        @Path("id_user") idUser: String,
        @Header("Authorization") token: String
    ): Call<ArrayList<Address>>

    @POST("address/create")
    fun create(
        @Body address: Address,
        @Header("Authorization") token: String
    ): Call<ResponseHttp>


}