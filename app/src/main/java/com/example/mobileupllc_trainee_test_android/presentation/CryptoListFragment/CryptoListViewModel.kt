package com.example.mobileupllc_trainee_test_android.presentation.CryptoListFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileupllc_trainee_test_android.domain.use_cases.GetCryptoListUseCase
import com.example.mobileupllc_trainee_test_android.util.ResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Currency
import javax.inject.Inject

class CryptoListViewModel @Inject constructor(
    private val getCryptoListUseCase: GetCryptoListUseCase
): ViewModel() {

    private val _cryptoList = MutableStateFlow(CryptoListState())
    val cryptoList: StateFlow<CryptoListState> = _cryptoList

    fun getCryptoList(vsCurrency: String) = viewModelScope.launch(Dispatchers.IO) {
        getCryptoListUseCase(vsCurrency).collect {
            when(it) {
                is ResponseState.Success -> {
                    _cryptoList.value = CryptoListState(cryptoList = it.data ?: emptyList())
                }
                is ResponseState.Loading -> {
                    _cryptoList.value = CryptoListState(loading = true)
                }
                is ResponseState.Error -> {
                    _cryptoList.value = CryptoListState(error = it.message ?: "Непредвиденная ошибка")
                }
            }
        }
    }
}