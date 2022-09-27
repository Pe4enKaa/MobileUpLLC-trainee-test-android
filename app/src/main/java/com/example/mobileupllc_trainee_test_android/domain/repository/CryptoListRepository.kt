package com.example.mobileupllc_trainee_test_android.domain.repository

import com.example.mobileupllc_trainee_test_android.data.data_source.dto.CryptoListDTO.CryptoListDTO
import com.example.relevelandroidproject.data.data_source.dto.CoinDetailDTO.CryptoItemDTO

interface CryptoListRepository {

    suspend fun getCryptoList(vsCurrency: String): CryptoListDTO

    suspend fun getCryptoItem(cryptoItemId: String): CryptoItemDTO
}