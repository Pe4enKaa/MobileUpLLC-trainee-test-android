package com.example.mobileupllc_trainee_test_android.domain.model

data class CryptoItem(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val currentPrice: Double,
    val priceChangePercentage24h: Double
) {
}