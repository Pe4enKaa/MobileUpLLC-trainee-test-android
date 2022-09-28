package com.example.mobileupllc_trainee_test_android.presentation.CryptoItemFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mobileupllc_trainee_test_android.R
import com.example.mobileupllc_trainee_test_android.databinding.CryptoItemFragmentBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CryptoItemFragment : Fragment() {

    private lateinit var binding: CryptoItemFragmentBinding

    private val viewModel: CryptoItemViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = CryptoItemFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolBar()
    }

    private fun setupToolBar() {
        binding.toolbarCryptoItem.setNavigationIcon(R.drawable.ic_back);

        binding.toolbarCryptoItem.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun setDataItem() {
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.cryptoItemValue.collect { value ->

                when {
                    value.loading -> {
                        binding.progressBarItem.visibility = View.VISIBLE
                    }
                    value.error.isNotBlank() -> {
                        binding.progressBarItem.visibility = View.GONE
                    }
                    value.cryptoItem != null -> {
                        binding.progressBarItem.visibility = View.GONE

                        Picasso.get().load(value.cryptoItem.image).into(binding.imageCryptoItem)
                        binding.descriptionCryptoItem.text = value.cryptoItem.description
                        binding.categoriesCryptoItem.text = value.cryptoItem.categories
                        binding.toolbarCryptoItem.title = value.cryptoItem.name
                    }
                }
                delay(1000)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        requireArguments().getString("idCrypto")?.let { Log.e("cryptoItem", it) }
        requireArguments().getString("idCrypto")?.let {
            viewModel.getCryptoItem(it)
            setDataItem()
        }
    }
}