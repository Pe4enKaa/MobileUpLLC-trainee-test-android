package com.example.mobileupllc_trainee_test_android.domain

import androidx.lifecycle.LiveData

interface CryptoListRepository {

    fun getCryptoList(): LiveData<List<CryptoItem>>

    fun getCryptoItem(cryptoItemID: Int): CryptoItem
}