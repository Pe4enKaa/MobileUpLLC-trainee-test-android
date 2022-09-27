package com.example.mobileupllc_trainee_test_android.presentation.CryptoListFragment

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileupllc_trainee_test_android.R
import de.hdodenhof.circleimageview.CircleImageView

class CryptoItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val imageCrypto = view.findViewById<CircleImageView>(R.id.image_crypto)
    val nameCrypto = view.findViewById<TextView>(R.id.name_crypto)
    val symbolCrypto = view.findViewById<TextView>(R.id.symbol_crypto)
    val priceCrypto = view.findViewById<TextView>(R.id.price_crypto)
    val priceChangeCrypto = view.findViewById<TextView>(R.id.price_change_crypto)

}