package com.example.mobileupllc_trainee_test_android.domain.use_cases

import com.example.mobileupllc_trainee_test_android.domain.model.CryptoItem
import com.example.mobileupllc_trainee_test_android.domain.repository.CryptoListRepository

class GetCryptoItemUseCase(private val repository: CryptoListRepository) {

    fun getCryptoItem(cryptoItemId: String): CryptoItem {
        return repository.getCryptoItem(cryptoItemId)
    }
}