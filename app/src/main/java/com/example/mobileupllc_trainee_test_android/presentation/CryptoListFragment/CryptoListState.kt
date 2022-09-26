package com.example.mobileupllc_trainee_test_android.presentation.CryptoListFragment

import com.example.mobileupllc_trainee_test_android.domain.model.CryptoItem

data class CryptoListState(
    val loading: Boolean = false,
    val cryptoList: List<CryptoItem> = emptyList(),
    val error: String = ""
)
