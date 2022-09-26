package com.example.mobileupllc_trainee_test_android.presentation.CryptoItemFragment

import com.example.mobileupllc_trainee_test_android.domain.model.CryptoItemDetail

data class CryptoItemState(
    val loading: Boolean = false,
    val cryptoItem: CryptoItemDetail? = null,
    val error: String = ""
)
