package com.example.mobileupllc_trainee_test_android.di

import com.example.mobileupllc_trainee_test_android.data.data_source.CryptoApi
import com.example.mobileupllc_trainee_test_android.data.repository.CryptoListRepositoryImpl
import com.example.mobileupllc_trainee_test_android.domain.repository.CryptoListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CryptoModule {

    @Provides
    @Singleton
    fun provideCryptoApi(): CryptoApi {
        return Retrofit.Builder()
            .baseUrl("https://api.coingecko.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCryptoRepository(api: CryptoApi): CryptoListRepository {
        return CryptoListRepositoryImpl(api)
    }

}