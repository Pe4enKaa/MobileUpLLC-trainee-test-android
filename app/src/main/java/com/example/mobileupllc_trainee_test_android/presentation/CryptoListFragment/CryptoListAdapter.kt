package com.example.mobileupllc_trainee_test_android.presentation.CryptoListFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import com.example.mobileupllc_trainee_test_android.R
import com.example.mobileupllc_trainee_test_android.domain.model.CryptoItem
import com.example.mobileupllc_trainee_test_android.util.CryptoItemDiffCallback
import com.squareup.picasso.Picasso
import java.text.DecimalFormat

class CryptoListAdapter : ListAdapter<CryptoItem, CryptoItemViewHolder>(CryptoItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_crypto, parent, false)
        return CryptoItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoItemViewHolder, position: Int) {
        val cryptoItem = getItem(position)

        Picasso.get().load(cryptoItem.image).into(holder.imageCrypto)
        holder.nameCrypto.text = cryptoItem.name
        holder.priceCrypto.text = DecimalFormat("#,###.##").format(cryptoItem.currentPrice)
        holder.symbolCrypto.text = cryptoItem.symbol

        if (cryptoItem.priceChangePercentage24h < NEGATIVE_NUMBER_VALUE) {
            holder.priceChangeCrypto.setTextColor(ContextCompat.getColor(holder.itemView.context,
                R.color.red))
            holder.priceChangeCrypto.text =
                String.format("%.2f", cryptoItem.priceChangePercentage24h) + "%"
        } else {
            holder.priceChangeCrypto.setTextColor(ContextCompat.getColor(holder.itemView.context,
                R.color.green))
            holder.priceChangeCrypto.text =
                "+" + String.format("%.2f", cryptoItem.priceChangePercentage24h) + "%"
        }

    }

    companion object {
        const val NEGATIVE_NUMBER_VALUE = 0
    }
}