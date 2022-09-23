package com.example.mobileupllc_trainee_test_android.domain.repository

import androidx.lifecycle.LiveData
import com.example.mobileupllc_trainee_test_android.data.data_source.dto.CryptoItemDTO.CryptoItemDTO
import com.example.mobileupllc_trainee_test_android.data.data_source.dto.CryptoListDTO.CryptoListDTO
import com.example.mobileupllc_trainee_test_android.domain.CryptoItem

interface CryptoListRepository {

    suspend fun getCryptoList(vsCurrency: String): CryptoListDTO

    suspend fun getCryptoItem(cryptoItemId: String): CryptoItemDTO
}