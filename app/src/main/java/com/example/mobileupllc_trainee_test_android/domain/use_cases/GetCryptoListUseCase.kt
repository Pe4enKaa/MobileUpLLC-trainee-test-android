package com.example.mobileupllc_trainee_test_android.domain.use_cases

import androidx.lifecycle.LiveData
import com.example.mobileupllc_trainee_test_android.domain.model.CryptoItem
import com.example.mobileupllc_trainee_test_android.domain.repository.CryptoListRepository

class GetCryptoListUseCase(private val repository: CryptoListRepository) {

    fun getCryptoList(): LiveData<List<CryptoItem>> {
        return repository.getCryptoList()
    }
}