package com.example.mobileupllc_trainee_test_android.presentation.CryptoItemFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileupllc_trainee_test_android.domain.model.CryptoItemDetail
import com.example.mobileupllc_trainee_test_android.domain.use_cases.GetCryptoItemUseCase
import com.example.mobileupllc_trainee_test_android.util.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoItemViewModel @Inject constructor(
    private val getCryptoItemUseCase: GetCryptoItemUseCase
): ViewModel() {

    private val _cryptoItemValue = MutableStateFlow(CryptoItemState())
    var cryptoItemValue: StateFlow<CryptoItemState> = _cryptoItemValue

    fun getCryptoItem(id: String) = viewModelScope.launch(Dispatchers.IO) {
        getCryptoItemUseCase(id).collect {
            when(it) {
                is ResponseState.Success -> {
                    _cryptoItemValue.value = CryptoItemState(cryptoItem = it.data)
                }
                is ResponseState.Loading -> {
                    _cryptoItemValue.value = CryptoItemState(loading = true)
                }
                is ResponseState.Error -> {
                    _cryptoItemValue.value = CryptoItemState(error = it.message ?: "Непредвиденная ошибка")
                }
            }
        }
    }
}