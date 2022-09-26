package com.example.mobileupllc_trainee_test_android.presentation.CryptoListFragment

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.mobileupllc_trainee_test_android.domain.model.CryptoItem
import com.example.mobileupllc_trainee_test_android.util.CryptoItemDiffCallback

class CryptoListAdapter: ListAdapter<CryptoItem, CryptoItemViewHolder>(CryptoItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CryptoItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}