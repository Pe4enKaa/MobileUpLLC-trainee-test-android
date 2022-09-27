package com.example.mobileupllc_trainee_test_android.presentation.CryptoItemFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mobileupllc_trainee_test_android.databinding.CryptoItemFragmentBinding
import com.example.mobileupllc_trainee_test_android.presentation.CryptoListFragment.CryptoListViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CryptoItemFragment: Fragment() {

    private lateinit var binding: CryptoItemFragmentBinding

    private val viewModel by viewModels<CryptoItemViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CryptoItemFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireArguments().getString("idCrypto")?.let { Log.e("onStart", it) }
        requireArguments().getString("idCrypto")?.let {
            viewModel.getCryptoItem(it)
            setDataItem(it)
        }
    }

    override fun onStart() {
        super.onStart()
        requireArguments().getString("idCrypto")?.let { Log.e("onStart", it) }
        requireArguments().getString("idCrypto")?.let {
            viewModel.getCryptoItem(it)
            setDataItem(it)
        }
    }

    private fun setDataItem(id: String) {
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.cryptoItem.collect{
                when {
                    it.loading -> {
                        binding.progressBarItem.visibility = View.VISIBLE
                    }
                    it.error.isNotBlank() -> {
                        binding.progressBarItem.visibility = View.GONE
                    }
                    it.cryptoItem != null -> {
                        binding.progressBarItem.visibility = View.GONE

                        Picasso.get().load(it.cryptoItem.image).into(binding.imageCryptoItem)

                        binding.descriptionCryptoItem.text = it.cryptoItem.description
                        binding.categoriesCryptoItem.text = it.cryptoItem.categories
                        binding.toolbarCryptoItem.title = it.cryptoItem.name
                        Log.e("setDataItem", it.cryptoItem.toString() )
                    }
                }
                delay(1000)
            }
        }
    }
}