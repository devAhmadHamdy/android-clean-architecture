package com.hamdi.androidcleanarchitecture.data.repository

import com.hamdi.androidcleanarchitecture.data.remote.CoinApi
import com.hamdi.androidcleanarchitecture.data.remote.dto.CoinDetailDto
import com.hamdi.androidcleanarchitecture.domain.repository.CoinRepository
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinApi):CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
       return api.getCoins()
    }

    override suspend fun getCoinById(coinId:String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}