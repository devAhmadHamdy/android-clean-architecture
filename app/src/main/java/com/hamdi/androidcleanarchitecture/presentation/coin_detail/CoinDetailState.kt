package com.hamdi.androidcleanarchitecture.presentation.coin_detail

import com.hamdi.androidcleanarchitecture.domain.model.CoinDetail


data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
