package com.example.mobileupllc_trainee_test_android.domain

data class CryptoItem(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val currentPrice: String,
    val priceChangePercentage24h: String
) {
}