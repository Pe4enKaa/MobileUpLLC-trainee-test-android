package com.example.mobileupllc_trainee_test_android.presentation.CryptoListFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.mobileupllc_trainee_test_android.R
import com.example.mobileupllc_trainee_test_android.databinding.CryptoListFragmentBinding
import com.example.mobileupllc_trainee_test_android.presentation.CryptoItemFragment.CryptoItemFragment
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CryptoListFragment: Fragment() {

    private lateinit var binding: CryptoListFragmentBinding

    private val viewModel by viewModels<CryptoListViewModel>()

    private lateinit var cryptoListAdapter: CryptoListAdapter

    private var cryptoItemFragment = CryptoItemFragment()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = CryptoListFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        setupCurrency()

        setupTransitionCryptoItem()
    }

    private fun setupTransitionCryptoItem() {
        cryptoListAdapter.onCryptoItemClickListener = {
            cryptoItemFragment.apply {
                arguments = Bundle().apply {
                    putString("idCrypto", it.id)
                }
            }
            fragmentManager?.beginTransaction()
                ?.replace(R.id.nav_host_fragment, cryptoItemFragment)
                ?.addToBackStack(null)
                ?.commit()
        }
    }

    private fun setupCurrency() {
        binding.chipGroup.setOnCheckedChangeListener { chipGroup, i ->
            val chip = chipGroup.findViewById<Chip>(i)
            when (chip.id) {
                R.id.chip_usd -> {
                    Log.e("chipGroup", chip.text.toString())
                    viewModel.getCryptoList("usd")
                }
                R.id.chip_eur -> {
                    Log.e("chipGroup", chip.text.toString())
                    viewModel.getCryptoList("eur")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getCryptoList("usd")
        setDataList()
    }

    private fun setDataList() {
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.cryptoList.collect{
                when {
                    it.loading -> {
                        binding.progressBarList.visibility = View.VISIBLE
                    }
                    it.error.isNotBlank() -> {
                        binding.progressBarList.visibility = View.GONE
                        Toast.makeText(context, it.error, Toast.LENGTH_LONG).show()
                    }
                    it.cryptoList.isNotEmpty() -> {
                        binding.progressBarList.visibility = View.GONE
                        cryptoListAdapter.submitList(it.cryptoList)
                    }
                }
                delay(1000)
            }
        }
    }

    private fun setupRecyclerView() {
        val rvCryptoList = binding.recyclerViewCrypto

        cryptoListAdapter = CryptoListAdapter()

        with(rvCryptoList) {
            adapter = cryptoListAdapter
        }
    }
}