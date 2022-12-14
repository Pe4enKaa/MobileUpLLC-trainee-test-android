package com.example.mobileupllc_trainee_test_android.domain.use_cases

import com.example.mobileupllc_trainee_test_android.domain.model.CryptoItemDetail
import com.example.mobileupllc_trainee_test_android.domain.repository.CryptoListRepository
import com.example.mobileupllc_trainee_test_android.util.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCryptoItemUseCase @Inject constructor(private val repository: CryptoListRepository) {

    operator fun invoke(id: String): Flow<ResponseState<CryptoItemDetail>> = flow {
        try {
            emit(ResponseState.Loading())
            val cryptoList = repository.getCryptoItem(id).toCryptoItem()
            emit(ResponseState.Success(cryptoList))
        } catch (exception: HttpException) {
            emit(ResponseState.Error(exception.localizedMessage
                ?: "Произошла непредвиденная ошибка"))
        } catch (exception: IOException) {
            emit(ResponseState.Error("Произошла ошибка"))
        }
    }
}