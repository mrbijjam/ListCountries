package com.countriesinfo.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

        private const val BASE_URL =
            "https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/"
        private val retrofit =  Retrofit.Builder()
            .baseUrl(BASE_URL)  // Replace with your API base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val countriesApi = retrofit.create(CountryApiService::class.java)

}