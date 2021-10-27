package com.hamdi.androidcleanarchitecture.domain.use_case.get_coin

import com.hamdi.androidcleanarchitecture.common.Resource
import com.hamdi.androidcleanarchitecture.data.remote.dto.toCoinDetail
import com.hamdi.androidcleanarchitecture.domain.model.CoinDetail
import com.hamdi.androidcleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An Expected Error Occured"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Can't Reach the server please try again"))
        }
    }
}