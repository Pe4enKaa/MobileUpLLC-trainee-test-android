package com.example.mobileupllc_trainee_test_android.presentation

import androidx.lifecycle.ViewModel
import com.example.mobileupllc_trainee_test_android.data.repository.CryptoListRepositoryImpl
import com.example.mobileupllc_trainee_test_android.domain.use_cases.GetCryptoListUseCase

class MainViewModel: ViewModel() {

    private val repository = CryptoListRepositoryImpl

    private val getCryptoListUseCase = GetCryptoListUseCase(repository)

    val cryptoList = getCryptoListUseCase.getCryptoList()
}