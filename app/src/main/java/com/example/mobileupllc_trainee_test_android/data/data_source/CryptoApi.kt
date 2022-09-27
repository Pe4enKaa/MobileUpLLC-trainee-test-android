package com.example.mobileupllc_trainee_test_android.data.data_source

import com.example.mobileupllc_trainee_test_android.data.data_source.dto.CryptoListDTO.CryptoListDTO
import com.example.relevelandroidproject.data.data_source.dto.CoinDetailDTO.CryptoItemDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CryptoApi {

    @GET("/api/v3/coins/markets?vs_currency=usd&per_page=25")
    suspend fun getCryptoList(@Query("vs_currency") vsCurrency: String): CryptoListDTO

    @GET("/api/v3/coins/{id}")
    suspend fun getCryptoItem(@Path("id") id:String): CryptoItemDTO
}