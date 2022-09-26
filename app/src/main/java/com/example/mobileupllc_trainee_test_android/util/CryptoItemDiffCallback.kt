package com.example.mobileupllc_trainee_test_android.util

import androidx.recyclerview.widget.DiffUtil
import com.example.mobileupllc_trainee_test_android.domain.model.CryptoItem

class CryptoItemDiffCallback: DiffUtil.ItemCallback<CryptoItem>() {

    override fun areItemsTheSame(oldItem: CryptoItem, newItem: CryptoItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CryptoItem, newItem: CryptoItem): Boolean {
        return oldItem == newItem
    }
}