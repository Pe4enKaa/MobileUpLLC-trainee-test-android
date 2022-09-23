package com.example.mobileupllc_trainee_test_android.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mobileupllc_trainee_test_android.data.data_source.CryptoApi
import com.example.mobileupllc_trainee_test_android.data.data_source.dto.CryptoItemDTO.CryptoItemDTO
import com.example.mobileupllc_trainee_test_android.data.data_source.dto.CryptoListDTO.CryptoListDTO
import com.example.mobileupllc_trainee_test_android.domain.CryptoItem
import com.example.mobileupllc_trainee_test_android.domain.repository.CryptoListRepository

class CryptoListRepositoryImpl(private val cryptoApi: CryptoApi) : CryptoListRepository {

    override suspend fun getCryptoList(vsCurrency: String): CryptoListDTO {
        return cryptoApi.getCryptoList(vsCurrency = vsCurrency)
    }

    override suspend fun getCryptoItem(cryptoItemId: String): CryptoItemDTO {
        return cryptoApi.getCryptoItem(id = cryptoItemId)
    }
}