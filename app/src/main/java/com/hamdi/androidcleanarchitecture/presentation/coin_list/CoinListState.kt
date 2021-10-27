package com.hamdi.androidcleanarchitecture.presentation.coin_list

import com.hamdi.androidcleanarchitecture.domain.model.Coin


data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
