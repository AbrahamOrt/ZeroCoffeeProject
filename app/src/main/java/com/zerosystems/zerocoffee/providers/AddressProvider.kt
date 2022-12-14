package com.zerosystems.zerocoffee.providers

import com.zerosystems.zerocoffee.api.ApiRoutes
import com.zerosystems.zerocoffee.models.Address
import com.zerosystems.zerocoffee.models.ResponseHttp
import com.zerosystems.zerocoffee.routes.AddressRoutes
import retrofit2.Call

class AddressProvider(val token: String) {

    private var addressRoutes: AddressRoutes? = null

    init {
        val api = ApiRoutes()
        addressRoutes = api.getAddressRoutes(token)
    }

    fun getAddress(idUser: String): Call<ArrayList<Address>>? {
        return addressRoutes?.getAddress(idUser, token)
    }

    fun create(address: Address): Call<ResponseHttp>? {
        return addressRoutes?.create(address, token)
    }

}