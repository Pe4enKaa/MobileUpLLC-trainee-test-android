package com.example.mobileupllc_trainee_test_android.domain.use_cases

import com.example.mobileupllc_trainee_test_android.domain.model.CryptoItem
import com.example.mobileupllc_trainee_test_android.domain.repository.CryptoListRepository
import com.example.mobileupllc_trainee_test_android.util.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCryptoListUseCase @Inject constructor (private val repository: CryptoListRepository) {

    operator fun invoke(vsCurrency: String): Flow<ResponseState<List<CryptoItem>>> = flow {
        try {
            emit(ResponseState.Loading())
            val cryptoList = repository.getCryptoList(vsCurrency).map {
                it.toCrypto()
            }
            emit(ResponseState.Success(cryptoList))
        }
        catch (exception: HttpException) {
            emit(ResponseState.Error(exception.localizedMessage?: "Произошла непредвиденная ошибка"))
        }
        catch (exception: IOException) {
            emit(ResponseState.Error("Произошла ошибка"))
        }
    }
}