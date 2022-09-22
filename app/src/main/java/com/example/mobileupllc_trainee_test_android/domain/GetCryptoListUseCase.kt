package com.example.mobileupllc_trainee_test_android.domain

import androidx.lifecycle.LiveData

class GetCryptoListUseCase(private val repository: CryptoListRepository) {

    fun getCryptoList(): LiveData<List<CryptoItem>> {
        return repository.getCryptoList()
    }
}