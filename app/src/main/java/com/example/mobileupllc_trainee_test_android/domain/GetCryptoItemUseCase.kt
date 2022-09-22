package com.example.mobileupllc_trainee_test_android.domain

class GetCryptoItemUseCase(private val repository: CryptoListRepository) {

    fun getCryptoItem(cryptoItemId: Int): CryptoItem {
        return repository.getCryptoItem(cryptoItemId)
    }
}