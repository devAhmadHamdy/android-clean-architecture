package com.hamdi.androidcleanarchitecture.domain.use_case.get_coins

import com.hamdi.androidcleanarchitecture.common.Resource
import com.hamdi.androidcleanarchitecture.domain.model.Coin
import com.hamdi.androidcleanarchitecture.domain.repository.CoinRepository
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An Expected Error Occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Can't Reach the server please try again"))
        }
    }
}